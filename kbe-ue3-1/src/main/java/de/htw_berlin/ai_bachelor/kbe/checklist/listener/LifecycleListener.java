package de.htw_berlin.ai_bachelor.kbe.checklist.listener;

import com.sun.faces.component.visit.FullVisitContext;

import javax.faces.component.UIComponent;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.xml.bind.SchemaOutputResolver;
import java.util.Iterator;
import java.util.List;

/**
 * Created by matthias.drummer on 11.06.15.
 */
public class LifecycleListener implements PhaseListener {

	int counti = 0;

	public void afterPhase(PhaseEvent phaseEvent) {
		System.out.println("Start After Phase: " + phaseEvent.getPhaseId().getName());
		if (phaseEvent.getPhaseId() == PhaseId.RESTORE_VIEW || phaseEvent.getPhaseId() == PhaseId.RENDER_RESPONSE) {
			if (phaseEvent.getPhaseId() == PhaseId.RESTORE_VIEW) {
				System.out.println("Postback? : " + phaseEvent.getFacesContext().isPostback());
			}
			if (phaseEvent.getFacesContext().getViewRoot() != null) {
				System.out.println("View Root Id: " + phaseEvent.getFacesContext().getViewRoot().getViewId());
				System.out.println("View Children Count: " + countUpChilds(phaseEvent.getFacesContext().getViewRoot()));

				counti = 0;

				phaseEvent.getFacesContext().getViewRoot().visitTree(new FullVisitContext(phaseEvent.getFacesContext()), new VisitCallback() {

					public VisitResult visit(VisitContext context, UIComponent target) {
						System.out.println(target.getClass().getName());
						counti++;
						return VisitResult.ACCEPT;
					}
				});
				System.out.println(counti);
			} else {
				System.out.println("View Root is null");
			}

		}
		System.out.println("End After Phase: " + phaseEvent.getPhaseId().getName());
		System.out.println("------------------------------------------------------------------------");
	}

	public void beforePhase(PhaseEvent phaseEvent) {
		System.out.println("Start Before Phase: " + phaseEvent.getPhaseId().getName());
		if (phaseEvent.getPhaseId() == PhaseId.RENDER_RESPONSE || phaseEvent.getPhaseId() == PhaseId.RESTORE_VIEW) {
			if (phaseEvent.getPhaseId() == PhaseId.RESTORE_VIEW) {
				System.out.println("Postback? : " + phaseEvent.getFacesContext().isPostback());
			}
			if (phaseEvent.getFacesContext().getViewRoot() != null) {
				System.out.println("View Root Id: " + phaseEvent.getFacesContext().getViewRoot().getViewId());
				System.out.println("View Children Count: " + countUpChilds(phaseEvent.getFacesContext().getViewRoot()));

				counti = 0;

				phaseEvent.getFacesContext().getViewRoot().visitTree(new FullVisitContext(phaseEvent.getFacesContext()), new VisitCallback() {

					public VisitResult visit(VisitContext context, UIComponent target) {
						System.out.println(target.getClass().getName());
						counti++;
						return VisitResult.ACCEPT;
					}
				});
				System.out.println(counti);
			} else {
				System.out.println("View root is null");
			}
		}
		System.out.println("End Before Phase: " + phaseEvent.getPhaseId().getName());
		System.out.println("------------------------------------------------------------------------");
	}

	private int countUpChilds(UIComponent component) {
		int count = 1;
		if (component.getChildren() != null && !component.getChildren().isEmpty()) {
			for (UIComponent com : component.getChildren()) {
				count += countUpChilds(com);
			}
		}
		return count;
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}
