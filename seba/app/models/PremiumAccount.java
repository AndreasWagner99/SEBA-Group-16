package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import models.Designer;

import org.hibernate.validator.constraints.CreditCardNumber;

import play.data.validation.Equals;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * Premium Account for Designer
 * @author Anamika
 *
 */
@Entity
public class PremiumAccount extends Model {

	@ManyToOne
	public Designer	designer;
	public String cardNumber;
	public String cardName;
	public String creditAmount;
	public String cVV;
	public String expiryDate;
	public String paymentMethod;
	
	public PremiumAccount(Designer designer, String cardNumber, String cardName, String creditAmount, String cVV, String expiryDate, String paymentMethod) {
		super();
		this.designer = designer;
		this.cardName = cardNumber;
		this.cardNumber = cardName;
		this.creditAmount = creditAmount;
		this.cVV = cVV;
		this.expiryDate = expiryDate;
		this.paymentMethod = paymentMethod;
	}
	
	

}
