package io.codera.quant.observers;

import com.ib.client.Decimal;
import com.ib.client.OrderState;
import com.ib.client.OrderStatus;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 *
 */
public class IbOrderObserver implements OrderObserver {

  private final PublishSubject<OrderState> orderSubject;

  public IbOrderObserver() {
    orderSubject = PublishSubject.create();
  }

  @Override
  public void orderState(OrderState orderState) {
    orderSubject.onNext(orderState);
  }

  public Observable<OrderState> observableOrderState() {
    return orderSubject.asObservable();
  }

	@Override
	public void orderStatus(OrderStatus arg0, Decimal arg1, Decimal arg2, double arg3, int arg4, int arg5, double arg6,
			int arg7, String arg8, double arg9) {
		// TODO Auto-generated method stub
		
	}
}
