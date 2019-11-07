
package acme.entities.banners;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CommercialBanner extends Banner {

	private static final long	serialVersionUID	= 1L;

	//Visa, mastercard, etc. Sacar pattern
	@NotBlank
	@Pattern(regexp = "^VISA|MASTER CARD|AMERICAN EXPRESS$")
	private String				brand;

	@NotNull
	@Min(100)
	@Max(999)
	private Integer				CVV;

	@NotNull
	@Min(1)
	@Max(12)
	private Integer				expirationMonth;

	@NotNull
	@Min(2019)
	private Integer				expirationYear;

}
