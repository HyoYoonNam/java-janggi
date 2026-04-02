package domain.game;

import domain.board.Intersection;
import domain.direction.Direction;
import domain.direction.Down;
import domain.direction.Left;
import domain.direction.MoveAmount;
import domain.direction.Right;
import domain.direction.Up;
import java.util.List;

public enum Side {
    HAN(1, new Down(), new Right()) {
        @Override
        public Side nextTurn() {
            return CHO;
        }
    },
    CHO(10, new Up(), new Left()) {
        @Override
        public Side nextTurn() {
            return HAN;
        }
    },
    NONE(0, new NoDirection(), new NoDirection()) {
        @Override
        public Side nextTurn() {
            return NONE;
        }
    };

    private final int baseRow;
    private final Direction forwardDirection;
    private final Direction backwardDirection;
    private final Direction leftDirection;
    private final Direction rightDirection;

    Side(
            int baseRow,
            Direction forwardDirection,
            Direction leftDirection
    ) {
        this.baseRow = baseRow;
        this.forwardDirection = forwardDirection;
        this.backwardDirection = forwardDirection.reverse();
        this.leftDirection = leftDirection;
        this.rightDirection = leftDirection.reverse();
    }

    public int getBaseRow() {
        return baseRow;
    }

    public Direction getForwardDirection() {
        return forwardDirection;
    }

    public Direction getBackwardDirection() {
        return backwardDirection;
    }

    public Direction getLeftDirection() {
        return leftDirection;
    }

    public Direction getRightDirection() {
        return rightDirection;
    }

    public List<Direction> getAllDirections() {
        return List.of(forwardDirection, backwardDirection, leftDirection, rightDirection);
    }

    public abstract Side nextTurn();

    private static class NoDirection implements Direction {

        @Override
        public Intersection moveForward(Intersection currentIntersection, MoveAmount moveAmount) {
            return currentIntersection;
        }

        @Override
        public Intersection moveLeft(Intersection currentIntersection, MoveAmount moveAmount) {
            return currentIntersection;
        }

        @Override
        public Intersection moveRight(Intersection currentIntersection, MoveAmount moveAmount) {
            return currentIntersection;
        }

        @Override
        public Intersection moveForwardLeft(Intersection currentIntersection, MoveAmount moveAmount) {
            return currentIntersection;
        }

        @Override
        public Intersection moveForwardRight(Intersection currentIntersection, MoveAmount moveAmount) {
            return currentIntersection;
        }

        @Override
        public Direction reverse() {
            return this;
        }
    }
}
