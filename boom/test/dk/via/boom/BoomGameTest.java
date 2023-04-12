package dk.via.boom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoomGameTest {

    private BoomGame game;

    @BeforeEach
    void setUp() {
        game = new BoomGame();
    }

    @Test
    void one_is_no_booms() {
        assertEquals(0, game.booms(1));
    }

    @Test
    void three_is_1_boom() {
        assertEquals(1, game.booms(3));
    }

    @Test
    void six_is_1_boom() {
        assertEquals(1, game.booms(6));
    }

    @Test
    void four_is_no_booms() {
        assertEquals(0, game.booms(4));
    }

    @Test
    void thirteen_is_1_boom() {
        assertEquals(1, game.booms(13));
    }

    @Test
    void thirty_one_is_1_boom() {
        assertEquals(1, game.booms(31));
    }

    @Test
    void thirty_three_is_2_boom() {
        assertEquals(2, game.booms(33));
    }

    @Test
    void one_is_one() {
        assertEquals("1", game.answer(1));
    }

    @Test
    void three_is_boom() {
        assertEquals("Boom", game.answer(3));
    }

    @Test
    void thirty_three_is_boom_boom() {
        assertEquals("BoomBoom", game.answer(33));
    }

    @Test
    void sequence_from_2_to_4_has_boom_in_the_middle() {
        assertIterableEquals(List.of("2", "Boom", "4"), game.boomSequence(2, 4));
    }

    @Test
    void sequence_from_30_to_33_has_boom_boom() {
        assertIterableEquals(List.of("Boom", "Boom", "Boom", "BoomBoom"), game.boomSequence(30, 33));
    }

    @Test
    void game_to_n_is_sequence_from_1_to_n() {
        assertIterableEquals(List.of("1", "2", "Boom", "4", "5", "Boom", "7", "8", "Boom", "10", "11", "Boom", "Boom"), game.play(13));
    }
}