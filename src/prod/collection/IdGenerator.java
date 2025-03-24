package prod.collection;

import java.util.HashSet;
import java.util.Random;

public class IdGenerator {

	/** Множество занятых идентификаторов */
    private static HashSet<Long> occupiedIds = new HashSet<>();
    /** Генератор случайных значений */
    private static Random random = new Random();

    /**
     * Генерирует новый уникальный идентификатор.
     *
     * @return Уникальный числовой идентификатор
     * @throws ArithmeticException При генерации нулевого делителя (маловероятно)
     */
    public long generateId() {
        long id;
        do {
            long timestamp = System.currentTimeMillis();
            long randomPart = random.nextInt(1000000);
            long randomDiv = random.nextInt(9999) + 1;

            id = (timestamp * 1000000 + randomPart) / randomDiv;
        } while (occupiedIds.contains(id));

        occupiedIds.add(id);
        return id;
    }
	
}
