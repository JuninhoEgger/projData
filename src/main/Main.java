package main;

import data.Data;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        Calendar dataAtual = Calendar.getInstance();
        byte dia = (byte) dataAtual.get(Calendar.DAY_OF_MONTH);
        byte mes = (byte) (1 + dataAtual.get(Calendar.MONTH));
        int ano = dataAtual.get(Calendar.YEAR);
        String dataAtualFormatada = dia + "/" + mes + "/" + ano;

        Data data = new Data();

        ArrayList<Byte> dias = new ArrayList<>();
        for (byte i = 1; i <= 31; i++) {
            dias.add(i);
        }

        ArrayList<Byte> meses = new ArrayList<>();
        for (byte i = 1; i <= 12; i++) {
            meses.add(i);
        }

        ArrayList<Integer> anos = new ArrayList<>();
        for (int i = 1900; i <= dataAtual.get(Calendar.YEAR); i++) {
            anos.add(i);
        }

        Object[] escolhaDias = dias.toArray();
        Object[] escolhaMeses = meses.toArray();
        Object[] escolhaAnos = anos.toArray();

        try {
            do {
                data.setDia((byte) JOptionPane.showInputDialog(
                        null,
                        "ESCOLHA UM DIA",
                        "DATA",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        escolhaDias,
                        escolhaDias[dataAtual.get(Calendar.DAY_OF_MONTH) - 1]
                ));

                data.setMes((byte) JOptionPane.showInputDialog(
                        null,
                        "ESCOLHA UM MÊS",
                        "DATA",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        escolhaMeses,
                        escolhaMeses[dataAtual.get(Calendar.MONTH)]
                ));

                data.setAno((int) JOptionPane.showInputDialog(
                        null,
                        "ESCOLHA UM DIA",
                        "DATA",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        escolhaAnos,
                        escolhaAnos[(escolhaAnos.length - 1)]
                ));
                if (!data.validarData()) {
                    JOptionPane.showMessageDialog(null, "DATA INVÁLIDA");
                }
            } while (!data.validarData());
        } catch (Exception e) {
            throw new Exception("\nNÃO FOI INFORMADO NENHUM VALOR!");
        }

        JOptionPane.showMessageDialog(
                null,
                "DATA DE HOJE: " + dataAtualFormatada +
                        "\nDATA SELECIONADA: " + data);

    }
}
