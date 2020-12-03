package br.com.magazineluiza.test.magalu.tests;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Testes {

    @Test
    public void teste01() {
        String[] array = {"Smartphone Samsung Galaxy S10 128GB Branco 4G - 8GB RAM Tela 6,1” Câm. Tripla + Câm. Selfie 10MP",
                "Smartphone Samsung Galaxy S10+ 128GB Azul 4G - 8GB RAM Tela 6,4” Câm. Tripla + Câm. Selfie Dupla",
                "Smartphone Samsung Galaxy S10 128GB Preto 4G - 8GB RAM Tela 6,1” Câm. Tripla + Câm. Selfie 10MP",
                "Smartphone Samsung Galaxy Note10 Lite - 128 GB -",
                "Galaxy S10 512GB - Samsung",
                "Smartphone Samsung Galaxy S10 128GB Preto 4G - Octa-Core 8GB RAM 6,1” Câm. Tripla + Selfie 10MP",
                "Smartphone Samsung Galaxy S10 Lite 128GB Azul 4G - Octa-Core 6GB RAM Tela 6,7” Câm.Tripla Selfie 32MP",
                "Smartphone Samsung Galaxy S10 Lite 128GB Preto 4G - Octa-Core 6GB RAM Tela 6,7” Câm.Tripla Selfie 32MP",
                "Smartphone Samsung Galaxy S10 Lite - 128 GB -",
                "Smartphone Samsung Galaxy S10+ 1TB -",
                "Smartphone Samsung Galaxy S10 - 128 GB -",
                "Película Gel Samsung Galaxy S10 Plus + Película Câmera Lente S10+ - Encapar",
                "Fone De Ouvido Samsung Galaxy S10/S10+ AKG Original -",
                "Película Gel 5d Nano Galaxy S10+ S10 Plus Cobre Tela 100% - Encapar",
                "Capa Anti Impacto Samsung Galaxy S10 - Transparente Flexível - Encapar",
                "Samsung Galaxy S10+ Branco",
                "com Tela de 6,4\"", "4G",
                "128 GB e Câmera Tripla de 12MP + 12MP + 16MP - SM-G975FZWJZTO -",
                "Capa Strong Magnética Luxo Smartphone Galaxy S10+ Plus (6,4) - Samsung",
                "Capa Personalizada Samsung Galaxy S10 Lite G770 - Mapa Mundi - MC01 - Matecki",
                "Smartphone Samsung Galaxy S10+ 128GB Preto 4G - Octa-Core 8GB RAM 6,4” Câm. Tripla + Selfie Dupla",
                "Smartphone Samsung Galaxy S10+ 128GB Azul - 8GB RAM 6,4” Câm. Tripla Câm. Selfie Dupla",
                "Capa Protetora Silicone Galaxy S10 Lite - Samsung",
                "Kit Película Gel Frente + Verso Samsung Galaxy S10 Plus - Encapar",
                "Capa Capinha Case Anti Impacto Samsung Galaxy S10 Lite 6.7 - H Maston",
                "Smartphone Samsung Galaxy S10+ - 128 GB -",
                "Capa Protetora Marvel - Samsung",
                "Capa de Couro S10 - - Samsung",
                "Capa Personalizada Samsung Galaxy S10 Lite G770 - Hightech - HG01 - Matecki",
                "Capa Original Samsung Clear View Cover Galaxy S10 G973 -",
                "Capa Personalizada Samsung Galaxy S10 Lite G770 - Pets - PE08 - Matecki",
                "Capa Protetora de Silicone Preta Samsung Galaxy S10 Plus -",
                "Capa de proteção samsung galaxy s10+ e s10 plus - case de silicone cover -",
                "Capa Tpu Antishock Case Bordas Reforçadas Samsung Galaxy S10 LITE 6.7 - Dv Acessorios",
                "Carregador Original Samsung Galaxy S10 TIPO C - Import",
                "Película De Vidro 3D 5D Samsung Galaxy S10 LITE (6.7) + Película Da Lente + Capa Reforçada - Dv Acessorios",
                "Capa Armor para Samsung Galaxy S10 Lite - Gshield -",
                "Celular samsung s10 preto -",
                "Case Capa Silicone Aveludada Samsung Galaxy S10 Plus Rosa - Sky Dreams Eletronics",
                "Película De Vidro Temperado 5D 3D Samsung Galaxy S10e S10 Lite G970 - 5.8 Polegadas - Sm",
                "Capa Personalizada Samsung Galaxy S10 Lite G770 - Estrelas - ST04 - Matecki",
                "Capa Carteira (PRETA) Flip Antishock Porta Cartão P/ Samsung Galaxy S10 LITE - 6.7 POLEGADAS - Dv Acessorios",
                "Fone de ouvido Samsung Galaxy S10+ AKG Preto Tipo C - Tyru",
                "Cabo Original Usb Samsung Galaxy Tipo C S8 S9 S9 PLUS S10 Note 8 A8 A11 A20s A21s A30 A30s A50 A70 -",
                "Smartphone Samsung Galaxy S10+, 6.4\", Android 9.0, 16MP, 128GB - Preto -",
                "Smartphone Samsung Galaxy S10, Dual Chip, Branco, Tela 6.1\", 4G+WiFi+NFC, Android 9.0, Câmera 12+16+12MP, 128GB -",
                "Smartphone Samsung Galaxy S10 128GB Preto 4G - 8GB RAM 6,1” Câm. Tripla + Câm. Selfie 10MP",
                "Capa para Samsung Galaxy S10 Plus 2019 G975 - Cell Case",
                "Case Capa Silicone Aveludada Samsung Galaxy S10 Plus Vermelha - Sky Dreams Eletronics",
                "Capa Case Magnética para Samsung Galaxy S10 Plus + Película de Silicone Frontal. - New Case",
                "Carregador Original Turbo Samsung Galaxy S8+ S9 S10 Plus EP-TA20 A20 A20s A30s A50 A70 A80 A90 -",
                "Capa Magnética Samsung Galaxy S10 - Para Samsung",
                "Capa Personalizada Samsung Galaxy S10 Lite G770 - Polvo - AT75 - Matecki",
                "Capa Samsung Galaxy S10 Tela de 6.1 Polegadas Silicone Cover Anti Impacto Verde Água -",
                "Capa Antishock Reforçada Samsung Galaxy S10 Lite 6.7 + 01 Película De Nano Gel - Dv Acessorios"};
        Collection<Object> lista = Arrays.asList(array);

        System.out.println(lista.stream().map(Object::toString)
                .collect(Collectors.joining("\n")));
    }
}
