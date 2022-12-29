package flow.steps.execurableflowstep;

import io.reactivex.rxjava3.core.Single;

public interface ExecutableFlowStep <I, O>{

    Single<O> execute (I input);
}
