package tn.dari.spring.payload.request;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    @NonNull private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    @NonNull private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    @NonNull  private String password;
    
    @NotBlank
    @NonNull private String nom;
    @NotBlank
    @NonNull private String prenom;
    
    @NotBlank
    private String address;
    @NotBlank
    @Size(min = 8, max = 12)
    private String tel;
    
    private boolean enabled;
    private String verificationCode;
	private boolean accountVerified;
	
	private Date birth;
 


    
    
}
