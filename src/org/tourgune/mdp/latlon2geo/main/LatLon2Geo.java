package org.tourgune.mdp.latlon2geo.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.tourgune.mdp.latlon2geo.bean.Address;
import org.tourgune.mdp.latlon2geo.bean.Results;
import org.tourgune.mdp.latlon2geo.bean.Root;

import com.google.gson.Gson;

public class LatLon2Geo {

	/**
	 * <p>Dados latitud y longitud, devuelve un Map<String, String> con la siguiente información:</p>
	 * <ul>		
	 *  <li>postal_code</li>
	 * 	<li>street_number</li>
	 * 	<li>route</li>
	 * 	<li>locality</li>
	 * 	<li>administrative_area_level_4</li>
	 * 	<li>administrative_area_level_3</li>
	 * 	<li>administrative_area_level_2</li>
	 * 	<li>administrative_area_level_1</li>
	 * <li>country</li>
	 * </ul>
	 * <p><b>NOTA:</b> Pueden no existir todos los campos</p>
	 * @param strLat
	 * @param strLon
	 * @return Map<String, String> (puede ser NULL)
	 * <p>Se devuelve NULL SI:</p>
	 * <ul>	
	 *  <li>No se ha encontrado información relacionada con las coordenadas pasadas</li>
	 *  <li>No se ha podido llamar al servicio de Google Geocoder (posible límite 
	 *  diario superado de 2500 peticiones)</li>
	 * </ul>
	 * @throws Exception
	 * <ul>  
	 *  <li>Si los valores de entrada de las coordenadas no son números válidos,
	 * se devolverá código de error -1 en la excepción (throw new Exception("-1"))</li>
	 * 	<li>En cualquier otro caso, la excepción (throw e)</li>
	 * </ul>
	 */
	public static Map<String, String> getGeoInfo(String strLat, String strLon) throws Exception{
		Map<String, String> mapGeo = null;
		
		boolean exit = false;
		double lat = 0;
		double lon = 0;
		
		Gson gson = null;
		String json = null;
		Root root = null;
		
		Map<String, List<Address>> mapAddresses = new HashMap<String, List<Address>>();
		
		try {
			lat = Double.parseDouble(strLat);
			lon = Double.parseDouble(strLon);
			
			gson = new Gson();
			
			json = Utils.getURL("http://maps.googleapis.com/maps/api/geocode/json?latlng=" + lat + "," + lon + "&sensor=false");
			
			root = gson.fromJson(json, Root.class);
			
			String status = root.getStatus();
			if ("OK".equals(status)) {
				List<Results> listResults = root.getResults();
				Iterator<Results> it2 = listResults.iterator();
				while (it2.hasNext()) {
					Results results = it2.next();
					mapAddresses.put(results.getTypes().get(0), results.getAddress_components());
				}
				// Establecemos prioridades para obtener los resultados más precisos
				List<Address> listAddress = mapAddresses.get("locality");
				if (listAddress == null) {
					listAddress = mapAddresses.get("route");
					if (listAddress == null) { 
						listAddress = mapAddresses.get("street_address");
						if (listAddress == null) { 
							listAddress = mapAddresses.get("postal_code");
							if (listAddress == null) { 
								listAddress = mapAddresses.get("administrative_area_level_3");
								if (listAddress == null) { 
									listAddress = mapAddresses.get("administrative_area_level_2");
									if (listAddress == null) { 
										listAddress = mapAddresses.get("administrative_area_level_1");
										if (listAddress == null) { 
											listAddress = mapAddresses.get("country");
										}
									}
								}
							}
						}
					}
				}
				Iterator<Address> it3 = listAddress.iterator();
				mapGeo = new HashMap<String, String>();
				
				while (it3.hasNext()) {
					 // Usamos reflection para usar el método que corresponda
					Address address = it3.next();
					List<String> listTypes = address.getTypes();
					if (!listTypes.isEmpty()) {
						String type = listTypes.get(0);
						mapGeo.put(type, address.getLong_name());
					}
				}
				
//				while (it2.hasNext() && !exit) {
//					Results results = it2.next();
//					// La mayoría de los mejores datos vienen cuando "type <> street_address" y "type <> postal_code" 
//					if (!results.getTypes().contains("route") 
//					FALTA RECOGER LA INFO DE ROUTE/STREET_NUMBER DE ESTOS RESULTS YA QUE EN EL "LOCALITY" NO APARECERÁ
//							&& !results.getTypes().contains("street_address") 
//							&& !results.getTypes().contains("postal_code") ) {
//						exit = true;
//						List<Address> listAddress = results.getAddress_components();
//						Iterator<Address> it3 = listAddress.iterator();
//						mapGeo = new HashMap<String, String>();
//						
//						while (it3.hasNext()) {
//							 // Usamos reflection para usar el método que corresponda
//							Address address = it3.next();
//							List<String> listTypes = address.getTypes();
//							if (!listTypes.isEmpty()) {
//								String type = listTypes.get(0);
//								mapGeo.put(type, address.getLong_name());
//							}
//						}
//					} 
//				}				
			} else { 
				// Devolver null, pero como ya está inicializado a NULL, no hacer nada
			}
		} catch (NumberFormatException nfe) {
			throw new Exception("-1");
		} catch (Exception e) {
			throw e;
		}
		
		return mapGeo;
	}

}
