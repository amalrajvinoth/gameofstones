package in.amal.rpg.gameofstones;

import org.junit.Before;
import org.junit.Test;

public class ProjectAcceptanceCriteria extends BaseTest {
	@Test
	public void as_a_player_I_want_to_create_a_character() {
		setUserInput("0\nAmal\n97".getBytes());
		Application.main(null);
		assertMessageIsPresent("game.exit.author");
	}

	@Test
	public void as_a_player_I_want_to_explore() {
		setUserInput("0\nAmal\n1\n0\n1\n0\n97".getBytes());
		Application.main(null);
	}

	@Test
	public void as_a_player_I_want_to_gain_experience_through_fighting() {
		setUserInput(
				"0\nAmal\n2\n2\n2\n2\n2\n2\n2\n2\n2\n2\n2\n1\n0\n2\n2\n2\n2\n2\n2\n2\n2\n2\n97"
						.getBytes());
		Application.main(null);
		assertMessageIsPresent("game.character.level", 2);
	}

	@Test
	public void as_a_player_I_want_to_save_and_resume_a_game() {
		saveGameTest();
		setUpBeforeTest();
		resumeGameTest();
	}

	private void resumeGameTest() {
		setUserInput("0\nAmal\n1\n0\n97".getBytes());
        Application.main(null);
        assertMessageIsPresent("game.welcome", "Amal");
	}

	private void saveGameTest() {
		setUserInput("0\n0\nAmal\n99\n97".getBytes());
		Application.main(null);
		assertMessageIsPresent("service.storage.save.success");
	}

	@Before
	@Override
	public void setUpBeforeTest() {
		super.setUpBeforeTest();
		Application.setExit(0);
	}

}