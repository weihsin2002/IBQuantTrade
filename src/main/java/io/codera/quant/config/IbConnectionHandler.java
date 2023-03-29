package io.codera.quant.config;

import com.google.common.collect.Lists;
import com.ib.controller.ApiController.IConnectionHandler;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class IbConnectionHandler implements IConnectionHandler {

  private static Logger logger = LoggerFactory.getLogger(IbConnectionHandler.class);
  private ArrayList<String> accountList = Lists.newArrayList();

  @Override
  public void connected() {
    logger.info("Connected");
  }

  @Override
  public void disconnected() {
    logger.info("Disconnected");
  }

  @Override
  public void accountList(List<String> list) {
    show("Received account list");
    accountList.clear();
    accountList.addAll(list);
  }

  @Override
  public void error(Exception e) {
    logger.error(e.getMessage());
    e.printStackTrace();
  }

  @Override
  public void message(int id, int errorCode, String errorMsg, String exception) { //exception to be verified
    logger.info("Message id: {}, errorCode: {}, errorMsg: {}, exception: {}", id, errorCode, errorMsg, exception);
  }

  @Override
  public void show(String string) {
    logger.info(string);
  }

  public ArrayList<String> getAccountList() {
    return accountList;
  }
}
