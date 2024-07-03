package ec.edu.ups.pweb.correojq.business;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;

import ec.edu.ups.pweb.correojq.model.Correo;
import jakarta.ejb.Stateless;

//atlas.ep26@gmail.com
//atlas1234
@Stateless
public class GestionCorreos {

	public void enviarCorreo(Correo correo) {
        Resend resend = new Resend("re_4RMohEjS_K3BaREANUtwaVjTvTnrCHirb");

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("onboarding@resend.dev")
                .to("atlas.ep26@gmail.com")
                .subject(correo.getSubject())
                .html("<strong>"+correo.getBody()+"</strong>")
                .build();

         try {
            CreateEmailResponse data = resend.emails().send(params);
            System.out.println(data.getId());
        } catch (ResendException e) {
            e.printStackTrace();
        }
	}
	
}