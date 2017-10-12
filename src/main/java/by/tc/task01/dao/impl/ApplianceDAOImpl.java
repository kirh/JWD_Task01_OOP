package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;


public final class ApplianceDAOImpl implements ApplianceDAO{

	private static final String APPLIANCE_DB_PATH = "/appliances_db.txt";

	private ApplianceFactory applianceFactory = new ApplianceFactory();

	@Override
	public <E> Appliance find(Criteria<E> criteria) {

		Appliance appliance = null;

		try(BufferedReader in = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream(APPLIANCE_DB_PATH), StandardCharsets.UTF_8)))
		{
			boolean isMatch = false;
			String line = null;
			while (!isMatch && (line = in.readLine()) != null){
				isMatch = matches(criteria, line);
			}
			if (isMatch){
				appliance = applianceFactory.createAppliance(criteria.getApplianceType(), createPropertiesMap(line));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return appliance;
	}

	private <E> boolean matches(Criteria<E> criteria, String applianceLine){
		boolean isMatch = typeMatches(criteria.getApplianceType(), applianceLine);
		if (!isMatch){
			return false;
		}
		Iterator<Map.Entry<E, Object>> criteriaIterator = criteria.getCriteria().entrySet().iterator();
		while (isMatch && criteriaIterator.hasNext()){
			Map.Entry<E, Object> next = criteriaIterator.next();
			String regex = new StringBuilder()
					.append(".*\\s")
					.append(next.getKey())
					.append('=')
					.append(next.getValue())
					.append("(,.*|;$)")
					.toString();
			isMatch = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(applianceLine).matches();
		}
		return isMatch;
	}

	private Map<String, Object> createPropertiesMap(String applianceLine){
		String[] properties = getProperties(applianceLine);
		HashMap<String, Object> propertiesMap = new HashMap<>();
		for (String property : properties){
			String[] entry = property.split("=");
			propertiesMap.put(entry[0], entry[1]);
		}
		return propertiesMap;
	}

	private boolean typeMatches(String type, String applianceString){
		return applianceString.startsWith(type);
	}

	private String[] getProperties(String applianceLine){
		applianceLine = applianceLine.substring(applianceLine.indexOf(": ") + 2);
		String[] properties = applianceLine.split("[:\\s,;]+");
		return properties;
	}

}