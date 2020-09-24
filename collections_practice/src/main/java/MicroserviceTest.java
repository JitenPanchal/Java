import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class MicroserviceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, UserStats> map1 = new HashMap<String, UserStats>();

		map1.put("1", new UserStats(Optional.of(3L)));
		
		map1.put("2", new UserStats(Optional.ofNullable(null)));

		Map<String, UserStats> map2 = new HashMap<String, UserStats>();
		map2.put("1", new UserStats(Optional.of(4L)));

		System.out.println(count(map1, map2));
	}

	static Map<Long, Long> count(Map<String, UserStats>... visits) {
		Map<Long, Long> result = new HashMap<Long, Long>();

		if (visits == null)
			return result;

		Stream.of(visits).forEach(mapItem -> {
			mapItem.forEach((id, userStat) -> {

				Long serviceId = 0L;
				try {
					serviceId = Long.parseLong(id);
				} catch (NumberFormatException e) {
					return;
				}

				if (userStat == null || !userStat.getVisitCount().isPresent()
						|| userStat.getVisitCount().get() == null) {
					return;
				}

				result.putIfAbsent(serviceId, 0L);
				result.computeIfPresent(serviceId, (w, prev) -> prev + userStat.getVisitCount().get());
			});
		});

		return result;
	}

}