package com.guotingchao.mb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Merchant
 * @Description: TODO(商铺)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-11 下午1:44:47
 * 
 */
public class Merchant implements Serializable {
	private static final long serialVersionUID = -23135289530102730L;

	private Long id;
	private String name;
	private String trade_description;
	private String tradeName;
	private String tradeContact;
	private String tradeAddress;
	private String tradeClass;
	private Date sysdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrade_description() {
		return trade_description;
	}

	public void setTrade_description(String trade_description) {
		this.trade_description = trade_description;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getTradeContact() {
		return tradeContact;
	}

	public void setTradeContact(String tradeContact) {
		this.tradeContact = tradeContact;
	}

	public String getTradeAddress() {
		return tradeAddress;
	}

	public void setTradeAddress(String tradeAddress) {
		this.tradeAddress = tradeAddress;
	}

	public String getTradeClass() {
		return tradeClass;
	}

	public void setTradeClass(String tradeClass) {
		this.tradeClass = tradeClass;
	}

	public Date getSysdate() {
		return sysdate;
	}

	public void setSysdate(Date sysdate) {
		this.sysdate = sysdate;
	}

}
