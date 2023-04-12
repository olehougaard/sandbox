package dk.via.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void a_new_stack_is_empty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void a_new_stack_has_size_0() {
        assertEquals(0, stack.size());
    }

    @Test
    void pushing_to_the_stack_makes_it_non_empty() {
        stack.push("Hello");
        assertFalse(stack.isEmpty());
    }

    @Test
    void pushing_to_the_stack_makes_the_size_grow() {
        stack.push("Hello");
        assertEquals(1, stack.size());
    }

    @Test
    void peeking_on_a_stack_with_a_pushed_element_returns_that_element() {
        stack.push("Hello");
        assertEquals("Hello", stack.peek());
    }

    @Test
    void popping_from_a_stack_with_a_pushed_element_returns_that_element() {
        stack.push("Hello");
        assertEquals("Hello", stack.pop());
    }

    @Test
    void popping_from_a_stack_with_a_pushed_element_leaves_it_with_size_0() {
        stack.push("Hello");
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    void peeking_on_a_stack_with_a_pushed_element_leaves_the_element() {
        stack.push("Hello");
        stack.peek();
        assertEquals(1, stack.size());
    }

    @Test
    void popping_from_a_stack_with_a_pushed_element_leaves_it_empty() {
        stack.push("Hello");
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void peeking_on_a_stack_with_two_pushed_elements_returns_the_last_element() {
        stack.push("Hello");
        stack.push("Goodbye");
        assertEquals("Goodbye", stack.peek());
    }

    @Test
    void popping_twice_from_a_stack_with_two_pushed_elements_returns_the_elements_in_reverse_order() {
        stack.push("Hello");
        stack.push("Goodbye");
        assertEquals("Goodbye", stack.pop());
        assertEquals("Hello", stack.pop());
    }

    /*
    @Test
    void pushing_nulls_is_not_allowed() {
        assertThrows(NullPointerException.class, () -> stack.push(null));
    }

    @Test
    void popping_from_a_new_stack_is_not_allowed() {
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void peeking_on_a_new_stack_is_not_allowed() {
        assertThrows(IllegalStateException.class, stack::peek);
    }
     */
}
