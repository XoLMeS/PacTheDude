package truelecter.problem_solving.pacthedude.action;

import truelecter.problem_solving.Action;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.state.WorldState;
import xolmes.WorldUtils;

public class MoveRightAction implements Action {

    @Override
    public State perform(State current) {
        if (!(current instanceof WorldState)) {
            throw new IllegalArgumentException("Can't move not in world");
        }
        return new WorldState((WorldState) current, this, ((WorldState) current).getPacmanLocation().right());

    }

    @Override
    public boolean applicable(State current) {
        if (current instanceof WorldState) {
            WorldState world = (WorldState) current;
            return WorldUtils.rightIsClear(world.getWorld(), world.getPacmanLocation().x, world.getPacmanLocation().y);
        }
        return false;
    }

}
