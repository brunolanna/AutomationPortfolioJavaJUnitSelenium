package login;

import dto.ConsultaProcessoNacionalidadeDto;

public class ConsultaProcessoNacionalidadeLogin {

    public static String login(String utilizador) {

        ConsultaProcessoNacionalidadeDto dto = new ConsultaProcessoNacionalidadeDto();

        if (utilizador.contains("Bruno")) {
            dto.setChaveBruno("9967-3931-7414");
        } else if (utilizador.contains("Leandro")) {
            dto.setChaveLeandro("6026-9838-7620");
        }

        return utilizador;
    }

}
