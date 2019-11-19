
package acme.entities.customization;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customization extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@ElementCollection
	@CollectionTable(name = "customization_spam_words", joinColumns = @JoinColumn(name = "customization_id"))
	@Column(name = "spam_words")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<String>		spamWords;

	@NotNull
	private Double				threshold;
}
