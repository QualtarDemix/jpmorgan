package test.jp.morgan.processor.test;

import org.junit.Test;
import test.jp.morgan.processor.ProcessorApplication;

public class ProcessorApplicationTest {

	String[] messages = {"20 sales of oranges at 10p each",
			"orange at 10p",
			"20 sales of pineapples at 10p each",
			"pineapple at 10p",
			"Add 20p apples",
			"5 sales of strawberries at 5p each",
			"strawberry at 5p",
			"2 sales of grapes at 15p each",
			"grapes at 15p",
			"Watermelon at 20p",  //tenth message
			"25 sales of watermelons at 20p each",
			"apple at 10p",
			"20 sales of oranges at 10p each",
			"orange at 10p",
			"20 sales of pineapples at 10p each",
			"pineapple at 10p",
			"5 sales of strawberries at 5p each",
			"strawberry at 5p",
			"2 sales of grapes at 15p each",
			"grapes at 15p",
			"Watermelon at 20p",
			"25 sales of watermelons at 20p each",
			"apple at 10p",
			"20 sales of oranges at 10p each",
			"orange at 10p",
			"20 sales of pineapples at 10p each",
			"pineapple at 10p",
			"5 sales of strawberries at 5p each",
			"strawberry at 5p",
			"2 sales of grapes at 15p each",
			"grapes at 15p",
			"Watermelon at 20p",
			"25 sales of watermelons at 20p each",
			"apple at 10p",
			"20 sales of oranges at 10p each",
			"orange at 10p",
			"20 sales of pineapples at 10p each",
			"pineapple at 10p",
			"5 sales of strawberries at 5p each",
			"strawberry at 5p",
			"2 sales of grapes at 15p each",
			"grapes at 15p",
			"Add 20p Watermelon",
			"Watermelon at 20p",
			"25 sales of watermelons at 20p each",
			"apple at 10p",
			"20 sales of oranges at 10p each",
			"orange at 10p",
			"20 sales of pineapples at 10p each",
			"pineapple at 10p",
			"5 sales of strawberries at 5p each",
			"strawberry at 5p",
			"2 sales of grapes at 15p each",
			"grapes at 15p",
			"Watermelon at 20p",
			"25 sales of watermelons at 20p each",
			"apple at 10p",        //fiftieth message
			"20 sales of oranges at 10p each",
			"orange at 10p", "20 sales of pineapples at 10p each",
			"pineapple at 10p",
			"5 sales of strawberries at 5p each",
			"strawberry at 5p",
			"2 sales of grapes at 15p each",
			"grapes at 15p",
			"Watermelon at 20p",
			"25 sales of watermelons at 20p each",
			"apple at 10p"};

	@Test
	public void testProcessor() {
		ProcessorApplication application = new ProcessorApplication();
		for (String message : messages) {
			application.processor(message);
		}
		assert(true);
	}

}
