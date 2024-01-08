package genetichelper;

import genetic.generator.Generator;
import genetic.killer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomKiller {
	private static final List<Class<? extends Killer>> KILLERS = new ArrayList<>(Arrays.asList(
		WeakestKiller.class,
		EqualChanceKiller.class,
//		RouletteKiller.class,
		ElementOfTheEliteKiller.class
	));

	public static Killer get(Generator generator) {
		int populationSize = generator.getCount();

		int chosenKillerIndex = (int) (Math.random() * KILLERS.size());
		Class<? extends Killer> killerClass = KILLERS.get(chosenKillerIndex);
		if (killerClass.equals(WeakestKiller.class)) {
			int reduceAmount = (int) (Math.random() * (populationSize - 2) + 2); // At least 2 should remain
			return new WeakestKiller(reduceAmount);
		} else if (killerClass.equals(EqualChanceKiller.class)) {
			int reduceAmount = (int) (Math.random() * (populationSize - 2) + 2); // At least 2 should remain
			return new EqualChanceKiller(reduceAmount);
		} else if (killerClass.equals(RouletteKiller.class)) {
			int reduceAmount = (int) (Math.random() * (populationSize - 2) + 2); // At least 2 should remain
			return new RouletteKiller(reduceAmount);
		} else { // ElementOfTheEliteKiller
			int eliteCount = ((int) (Math.random() * (populationSize - 1) + 1)) / 10 + 1; // At least 1 should be called "Elite" and it should be a small number
			int reduceCount = (int) (Math.random() * (populationSize - eliteCount - 1) + 1); // At least 1 should be killed
			return new ElementOfTheEliteKiller(eliteCount, reduceCount);
		}
	}
}
