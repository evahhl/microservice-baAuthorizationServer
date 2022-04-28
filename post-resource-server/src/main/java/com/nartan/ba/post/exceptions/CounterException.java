package com.nartan.ba.post.exceptions;

/**
 * @author evahhl
 *
 */
public class CounterException extends RuntimeException {

  private String errCode;
  private String errMsg;

  public CounterException(String errMsg) {
    this.errMsg = errMsg;
  }


  /**
   * @return the errCode
   */
  public String getErrCode() {
    return errCode;
  }

  /**
   * @param errCode the errCode to set
   */
  public void setErrCode(String errCode) {
    this.errCode = errCode;
  }

  /**
   * @return the errMsg
   */
  public String getErrMsg() {
    return errMsg;
  }

  /**
   * @param errMsg the errMsg to set
   */
  public void setErrMsg(String errMsg) {
    this.errMsg = errMsg;
  }
}