package br.com.purchaseclient.purchase;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class ClientDTO {

	@NotNull
	private Long id;

	private String name;
	private Integer age;
	private String telephone;
	private String email;
	private String sex;

}
