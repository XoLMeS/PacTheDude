package truelecter.problem_solving.pacthedude.action;

import truelecter.problem_solving.Action;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.state.WorldState;
import xolmes.WorldUtils;

public class MoveDownAction implements Action {

    @Override
    public State perform(State current) {
        if (!(current instanceof WorldState)) {
            throw new IllegalArgumentException("Can't move not in world");
        }
        WorldState state = (WorldState) current;
        state.mark(state.getPacmanLocation().down());
        return new WorldState(state, this, state.getPacmanLocation().down());
    }

    @Override
    public boolean applicable(State current) {
        if (current instanceof WorldState) {
            WorldState world = (WorldState) current;
            return WorldUtils.bottomIsClear(world.getWorld(), world.getPacmanLocation().x, world.getPacmanLocation().y)
                    && !world.marked(world.getPacmanLocation().down());
        }
        return false;
    }

}
