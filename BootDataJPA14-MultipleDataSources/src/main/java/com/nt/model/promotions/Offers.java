//offers.java
package com.nt.model.promotions;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="MDS_OFFERS")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Offers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer offerId;
	@NonNull
	@Column(length = 20)
	private  String  offerName;
	@Column(length = 20)
	@NonNull
	private String offerCode;
	@NonNull
	private  Double discountPercentage;
	@NonNull
	private  LocalDateTime expirtyDate;

}
