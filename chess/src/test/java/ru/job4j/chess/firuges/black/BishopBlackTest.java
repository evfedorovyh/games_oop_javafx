package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    public void whenCellIsF3ThenPositionIsF3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F3);
        Cell expected = bishopBlack.position();
        assertThat(expected.toString()).isEqualTo("F3");
    }

    @Test
    public void whenCellIsF3ThenCopyToD5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F3);
        Cell expected = bishopBlack.copy(Cell.D5).position();
        assertThat(expected.toString()).isEqualTo("D5");
    }

    @Test
    public void whenWayFromC1ToG5ThenD2E3F4G5() {
        Cell[] expected = new BishopBlack(Cell.C1).way(Cell.G5);
        assertThat(expected).isEqualTo(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5});
    }

    @Test
    public void whenWayFromC1ToG4ThenException() {
        ImpossibleMoveException exception = Assert.assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    new BishopBlack(Cell.C1).way(Cell.G4);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to G4");
    }
}