import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;


public class MicroserviceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Map<String, UserStats> map1 = new HashMap<String, UserStats>();
		
		UserStats user1 = new UserStats(Optional.of(1L));
		
		UserStats user2 = new UserStats(Optional.of(2L));
		
		
		map1.put("1", new UserStats(Optional.of(1L)));
		map1.put("3", new UserStats(Optional.of(2L)));
		map1.put("2", new UserStats(Optional.ofNullable(null)));
		map1.put("233", new UserStats(Optional.ofNullable(null)));

//		map1.put(null, new UserStats(Optional.of(1L)));
		
		Map<String, UserStats> map2 = new HashMap<String, UserStats>();

		System.out.println(count(map1,map2));
	}
	
	static Map<Long, Long> count(Map<String, UserStats>... visits) {
		Map<Long, Long> result = new HashMap<Long, Long>();

		if (visits == null)
			return result;
		
		Stream.of(visits).flatMap(it -> Stream.of(it)).forEach(it -> System.out.println(it));
		
		
		for (Map<String, UserStats> mapItem : visits) {

			if (mapItem == null)
				continue;

			mapItem.keySet().removeIf(item -> {
				try {
					Long.parseLong(item);
					return false;
				} catch (NumberFormatException e) {
					return true;
				}
			});
			mapItem.values().removeIf(item -> {
				return (item == null ||  !item.getVisitCount().isPresent() || item.getVisitCount().get() == null);
			});
		}

		for (Map<String, UserStats> mapItem : visits) {
			for (Map.Entry<String, UserStats> entry : mapItem.entrySet()) {

				UserStats userStat = entry.getValue();
				Long userId = Long.parseLong(String.valueOf(userStat.hashCode()));

				if (!result.containsKey(userId)) {
					result.put(userId, userStat.getVisitCount().orElse(0L));
				} else {
					result.put(userId, userStat.getVisitCount().get() + result.get(userId));
				}

			}
		}

		return result;
	}

}
