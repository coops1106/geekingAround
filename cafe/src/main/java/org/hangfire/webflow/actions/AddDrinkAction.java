package org.hangfire.webflow.actions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.samples.cafe.Cafe;
import org.springframework.integration.samples.cafe.DrinkType;
import org.springframework.integration.samples.cafe.Order;
import org.springframework.webflow.action.FormAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;


public class AddDrinkAction extends FormAction {
	@Autowired
	Cafe myCafe;
	
	public Event addDrink(RequestContext ctx) {
		System.out.println("Adding drink action");
		ctx.getFlowScope().put("out", "Adding drink action");
		
		Order order = new Order(1);
		
		String drink = ctx.getRequestParameters().get("drink");
		if (drink.equals("Latte")) {
			order.addItem(DrinkType.LATTE, 2, false);
		} else if(drink.equals("Espresso")) {
			order.addItem(DrinkType.ESPRESSO, 2, false);
		} else if(drink.equals("Mocha")) {
			order.addItem(DrinkType.MOCHA, 2, false);
		} else if(drink.equals("Cappuccino")) {
			order.addItem(DrinkType.CAPPUCCINO, 2, false);
		}
		
		myCafe.placeOrder(order);
		return success();
	}
	
}
