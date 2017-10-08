package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import org.apache.commons.beanutils.BeanUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ApplianceDAOImpl implements ApplianceDAO{

	private static final String APPLIANCE_ENTITY_PACKAGE = Appliance.class.getPackage().getName();

	@Override
	public <E> Appliance find(Criteria<E> criteria) {

		if (criteria.isEmpty()){
			return null;
		}

		try(BufferedReader in = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/appliances_db.txt"), StandardCharsets.UTF_8)))
		{
			boolean found = false;
			String line = null;
			while (!found && (line = in.readLine()) != null){
				found = matches(criteria, line);
			}
			if (found){
				return getAppliance(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private <E> boolean matches(Criteria<E> criteria, String line){
		boolean matches;
		matches = line.startsWith(criteria.getApplianceType());
		Iterator<Map.Entry<E, Object>> criteriaIterator = criteria.getCriteria().entrySet().iterator();
		while (matches && criteriaIterator.hasNext()){
			Map.Entry<E, Object> next = criteriaIterator.next();
			matches = line.contains(next.getKey() + "=" + next.getValue());
		}
		return matches;
	}

	private Appliance getAppliance(String line){
		String type = line.substring(0, line.indexOf(' '));
		Map<String, String> propertiesMap = createPropertiesMap(line);

		try {
			Object object = Class.forName(APPLIANCE_ENTITY_PACKAGE + "." + type).newInstance();
			BeanUtils.populate(object, propertiesMap);
			if (object instanceof Appliance){
				return (Appliance) object;
			}
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Map<String, String> createPropertiesMap(String line){
		line = line.substring(line.indexOf(": ") + 2);
		String[] props = line.split("[:\\s,;]+");
		HashMap<String, String> properties = new HashMap<>();
		for (String property : props){
			String[] split = property.split("=");
			String value = split[1];
			String[] keyWords = split[0].toLowerCase().split("_");
			String key = "";
			for (int i = 0; i < keyWords.length; i++){
				if (i > 0){
					keyWords[i] = keyWords[i].substring(0,1).toUpperCase() + keyWords[i].substring(1);
				}
				key += keyWords[i];
			}

			properties.put(key, value);

		}
		return properties;
	}

}