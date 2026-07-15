package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class HomeController {

    // Catálogo de vehículos Toyota (id → datos)
    private static final Map<Integer, VehiculoInfo> CATALOGO = new LinkedHashMap<>();

    static {
        CATALOGO.put(1, new VehiculoInfo(1, "Toyota 2016 RAV4 LE AWD", "62 039 Km | AUTOMÁTICO | 2500cc | GASOLINA", "toyota", "rav4_2016.jpg",   Arrays.asList("rav4_2016_b.jpg",   "rav4_2016_c.jpg",   "rav4_2016_d.jpg"),   null, 2));
        CATALOGO.put(2, new VehiculoInfo(2, "Toyota 2014 Yaris SE",    "45 000 Km | AUTOMÁTICO | 1500cc | GASOLINA", "toyota", "yaris_2014.jpg",  Arrays.asList("yaris_2014_b.jpg",  "yaris_2014_c.jpg",  "yaris_2014_d.jpg"),  1, 3));
        CATALOGO.put(3, new VehiculoInfo(3, "2023 Toyota Rush G",      "62 039 Km | AUTOMÁTICO | 1500cc | GASOLINA", "toyota", "rush_2023.jpg",   Arrays.asList("rush_2023_b.jpg",   "rush_2023_c.jpg",   "rush_2023_d.jpg"),   2, 4));
        CATALOGO.put(4, new VehiculoInfo(4, "2024 Toyota Yaris E",     "12 000 Km | AUTOMÁTICO | 1500cc | GASOLINA", "toyota", "yaris_2024.jpg",  Arrays.asList("yaris_2024_b.jpg",  "yaris_2024_c.jpg",  "yaris_2024_d.jpg"),  3, 5));
        CATALOGO.put(5, new VehiculoInfo(5, "2007 Toyota Yaris",       "98 500 Km | AUTOMÁTICO | 1500cc | GASOLINA", "toyota", "yaris_2007.jpg",  Arrays.asList("yaris_2007_b.jpg",  "yaris_2007_c.jpg",  "yaris_2007_d.jpg"),  4, 6));
        CATALOGO.put(6, new VehiculoInfo(6, "2002 Toyota RAV4",        "120 000 Km | AUTOMÁTICO | 2000cc | GASOLINA","toyota", "rav4_2002.jpg",   Arrays.asList("rav4_2002_b.jpg",   "rav4_2002_c.jpg",   "rav4_2002_d.jpg"),   5, 7));
        CATALOGO.put(7, new VehiculoInfo(7, "2019 Toyota Tacoma",      "55 000 Km | AUTOMÁTICO | 3500cc | GASOLINA", "toyota", "tacoma_2019.jpg", Arrays.asList("tacoma_2019_b.jpg", "tacoma_2019_c.jpg", "tacoma_2019_d.jpg"), 6, 8));
        CATALOGO.put(8, new VehiculoInfo(8, "2014 Toyota RAV4",        "87 000 Km | MANUAL | 2500cc | GASOLINA",     "toyota", "rav4_2014.jpg",   Arrays.asList("rav4_2014_b.jpg",   "rav4_2014_c.jpg",   "rav4_2014_d.jpg"),   7, null));

        // ── HONDA (ids 11-18) ──
        CATALOGO.put(11, new VehiculoInfo(11, "Honda Civic 2020",    "40 000 Km | AUTOMÁTICO | 1500cc | GASOLINA",  "honda", "civic_2020.jpg",    Arrays.asList("civic_2020_b.jpg",    "civic_2020_c.jpg",    "civic_2020_d.jpg"),    null, 12));
        CATALOGO.put(12, new VehiculoInfo(12, "Honda CR-V 2019",     "55 000 Km | AUTOMÁTICO | 2000cc | GASOLINA",  "honda", "crv_2019.jpg",      Arrays.asList("crv_2019_b.jpg",      "crv_2019_c.jpg",      "crv_2019_d.jpg"),      11, 13));
        CATALOGO.put(13, new VehiculoInfo(13, "Honda HR-V 2021",     "28 000 Km | AUTOMÁTICO | 1800cc | GASOLINA",  "honda", "hrv_2021.jpg",      Arrays.asList("hrv_2021_b.jpg",      "hrv_2021_c.jpg",      "hrv_2021_d.jpg"),      12, 14));
        CATALOGO.put(14, new VehiculoInfo(14, "Honda Fit 2018",      "72 000 Km | AUTOMÁTICO | 1300cc | GASOLINA",  "honda", "fit_2018.jpg",      Arrays.asList("fit_2018_b.jpg",      "fit_2018_c.jpg",      "fit_2018_d.jpg"),      13, 15));
        CATALOGO.put(15, new VehiculoInfo(15, "Honda Pilot 2017",    "90 000 Km | AUTOMÁTICO | 3500cc | GASOLINA",  "honda", "pilot_2017.jpg",    Arrays.asList("pilot_2017_b.jpg",    "pilot_2017_c.jpg",    "pilot_2017_d.jpg"),    14, 16));
        CATALOGO.put(16, new VehiculoInfo(16, "Honda Accord 2016",   "105 000 Km | AUTOMÁTICO | 2400cc | GASOLINA", "honda", "accord_2016.jpg",   Arrays.asList("accord_2016_b.jpg",   "accord_2016_c.jpg",   "accord_2016_d.jpg"),   15, 17));
        CATALOGO.put(17, new VehiculoInfo(17, "Honda CR-V 2015",     "120 000 Km | AUTOMÁTICO | 2400cc | GASOLINA", "honda", "crv_2015.jpg",      Arrays.asList("crv_2015_b.jpg",      "crv_2015_c.jpg",      "crv_2015_d.jpg"),      16, 18));
        CATALOGO.put(18, new VehiculoInfo(18, "Honda Jazz 2014",     "130 000 Km | AUTOMÁTICO | 1300cc | GASOLINA", "honda", "jazz_2014.jpg",     Arrays.asList("jazz_2014_b.jpg",     "jazz_2014_c.jpg",     "jazz_2014_d.jpg"),     17, null));

        // ── HYUNDAI (ids 21-28) ──
        CATALOGO.put(21, new VehiculoInfo(21, "Hyundai Tucson 2022",   "18 000 Km | AUTOMÁTICO | 2000cc | GASOLINA",  "hyundai", "tucson_2022.jpg",   Arrays.asList("tucson_2022_b.jpg",   "tucson_2022_c.jpg",   "tucson_2022_d.jpg"),   null, 22));
        CATALOGO.put(22, new VehiculoInfo(22, "Hyundai Elantra 2021",  "35 000 Km | AUTOMÁTICO | 2000cc | GASOLINA",  "hyundai", "elantra_2021.jpg",  Arrays.asList("elantra_2021_b.jpg",  "elantra_2021_c.jpg",  "elantra_2021_d.jpg"),  21, 23));
        CATALOGO.put(23, new VehiculoInfo(23, "Hyundai Creta 2020",    "47 000 Km | AUTOMÁTICO | 1600cc | GASOLINA",  "hyundai", "creta_2020.jpg",    Arrays.asList("creta_2020_b.jpg",    "creta_2020_c.jpg",    "creta_2020_d.jpg"),    22, 24));
        CATALOGO.put(24, new VehiculoInfo(24, "Hyundai Accent 2019",   "62 000 Km | AUTOMÁTICO | 1600cc | GASOLINA",  "hyundai", "accent_2019.jpg",   Arrays.asList("accent_2019_b.jpg",   "accent_2019_c.jpg",   "accent_2019_d.jpg"),   23, 25));
        CATALOGO.put(25, new VehiculoInfo(25, "Hyundai Santa Fe 2018", "80 000 Km | AUTOMÁTICO | 2400cc | GASOLINA",  "hyundai", "santafe_2018.jpg",  Arrays.asList("santafe_2018_b.jpg",  "santafe_2018_c.jpg",  "santafe_2018_d.jpg"),  24, 26));
        CATALOGO.put(26, new VehiculoInfo(26, "Hyundai i10 2017",      "95 000 Km | AUTOMÁTICO | 1000cc | GASOLINA",  "hyundai", "i10_2017.jpg",      Arrays.asList("i10_2017_b.jpg",      "i10_2017_c.jpg",      "i10_2017_d.jpg"),      25, 27));
        CATALOGO.put(27, new VehiculoInfo(27, "Hyundai Ioniq 2021",    "22 000 Km | AUTOMÁTICO | HÍBRIDO | GASOLINA", "hyundai", "ioniq_2021.jpg",    Arrays.asList("ioniq_2021_b.jpg",    "ioniq_2021_c.jpg",    "ioniq_2021_d.jpg"),    26, 28));
        CATALOGO.put(28, new VehiculoInfo(28, "Hyundai Kona 2022",     "15 000 Km | AUTOMÁTICO | 2000cc | GASOLINA",  "hyundai", "kona_2022.jpg",     Arrays.asList("kona_2022_b.jpg",     "kona_2022_c.jpg",     "kona_2022_d.jpg"),     27, null));

        // ── PORSCHE (ids 31-38) ──
        CATALOGO.put(31, new VehiculoInfo(31, "Porsche 911 2020",      "25 000 Km | AUTOMÁTICO | 3000cc | GASOLINA", "porche", "911_2020.jpg",      Arrays.asList("911_2020_b.jpg",      "911_2020_c.jpg",      "911_2020_d.jpg"),      null, 32));
        CATALOGO.put(32, new VehiculoInfo(32, "Porsche Cayenne 2019",  "40 000 Km | AUTOMÁTICO | 3000cc | GASOLINA", "porche", "cayenne_2019.jpg",  Arrays.asList("cayenne_2019_b.jpg",  "cayenne_2019_c.jpg",  "cayenne_2019_d.jpg"),  31, 33));
        CATALOGO.put(33, new VehiculoInfo(33, "Porsche Macan 2021",    "30 000 Km | AUTOMÁTICO | 2000cc | GASOLINA", "porche", "macan_2021.jpg",    Arrays.asList("macan_2021_b.jpg",    "macan_2021_c.jpg",    "macan_2021_d.jpg"),    32, 34));
        CATALOGO.put(34, new VehiculoInfo(34, "Porsche Panamera 2018", "55 000 Km | AUTOMÁTICO | 2900cc | GASOLINA", "porche", "panamera_2018.jpg", Arrays.asList("panamera_2018_b.jpg", "panamera_2018_c.jpg", "panamera_2018_d.jpg"), 33, 35));
        CATALOGO.put(35, new VehiculoInfo(35, "Porsche Boxster 2017",  "62 000 Km | AUTOMÁTICO | 2500cc | GASOLINA", "porche", "boxster_2017.jpg",  Arrays.asList("boxster_2017_b.jpg",  "boxster_2017_c.jpg",  "boxster_2017_d.jpg"),  34, 36));
        CATALOGO.put(36, new VehiculoInfo(36, "Porsche Taycan 2022",   "10 000 Km | AUTOMÁTICO | ELÉCTRICO",         "porche", "taycan_2022.jpg",   Arrays.asList("taycan_2022_b.jpg",   "taycan_2022_c.jpg",   "taycan_2022_d.jpg"),   35, 37));
        CATALOGO.put(37, new VehiculoInfo(37, "Porsche Cayman 2016",   "70 000 Km | MANUAL | 2700cc | GASOLINA",     "porche", "cayman_2016.jpg",   Arrays.asList("cayman_2016_b.jpg",   "cayman_2016_c.jpg",   "cayman_2016_d.jpg"),   36, 38));
        CATALOGO.put(38, new VehiculoInfo(38, "Porsche Cayenne 2015",  "88 000 Km | AUTOMÁTICO | 3600cc | GASOLINA", "porche", "cayenne_2015.jpg",  Arrays.asList("cayenne_2015_b.jpg",  "cayenne_2015_c.jpg",  "cayenne_2015_d.jpg"),  37, null));

        // ── SUBARU (ids 41-48) ──
        CATALOGO.put(41, new VehiculoInfo(41, "Subaru Outback 2021",  "20 000 Km | AUTOMÁTICO | 2500cc | GASOLINA", "subaru", "outback_2021.jpg",  Arrays.asList("outback_2021_b.jpg",  "outback_2021_c.jpg",  "outback_2021_d.jpg"),  null, 42));
        CATALOGO.put(42, new VehiculoInfo(42, "Subaru Forester 2020", "38 000 Km | AUTOMÁTICO | 2000cc | GASOLINA", "subaru", "forester_2020.jpg", Arrays.asList("forester_2020_b.jpg", "forester_2020_c.jpg", "forester_2020_d.jpg"), 41, 43));
        CATALOGO.put(43, new VehiculoInfo(43, "Subaru Impreza 2019",  "50 000 Km | AUTOMÁTICO | 2000cc | GASOLINA", "subaru", "impreza_2019.jpg",  Arrays.asList("impreza_2019_b.jpg",  "impreza_2019_c.jpg",  "impreza_2019_d.jpg"),  42, 44));
        CATALOGO.put(44, new VehiculoInfo(44, "Subaru XV 2022",       "14 000 Km | AUTOMÁTICO | 2000cc | GASOLINA", "subaru", "xv_2022.jpg",       Arrays.asList("xv_2022_b.jpg",       "xv_2022_c.jpg",       "xv_2022_d.jpg"),       43, 45));
        CATALOGO.put(45, new VehiculoInfo(45, "Subaru Legacy 2018",   "75 000 Km | AUTOMÁTICO | 2500cc | GASOLINA", "subaru", "legacy_2018.jpg",   Arrays.asList("legacy_2018_b.jpg",   "legacy_2018_c.jpg",   "legacy_2018_d.jpg"),   44, 46));
        CATALOGO.put(46, new VehiculoInfo(46, "Subaru WRX 2020",      "45 000 Km | MANUAL | 2000cc | GASOLINA",     "subaru", "wrx_2020.jpg",      Arrays.asList("wrx_2020_b.jpg",      "wrx_2020_c.jpg",      "wrx_2020_d.jpg"),      45, 47));
        CATALOGO.put(47, new VehiculoInfo(47, "Subaru Baja 2006",     "140 000 Km | MANUAL | 2500cc | GASOLINA",    "subaru", "baja_2006.jpg",     Arrays.asList("baja_2006_b.jpg",     "baja_2006_c.jpg",     "baja_2006_d.jpg"),     46, 48));
        CATALOGO.put(48, new VehiculoInfo(48, "Subaru Ascent 2023",   "8 000 Km | AUTOMÁTICO | 2400cc | GASOLINA",  "subaru", "ascent_2023.jpg",   Arrays.asList("ascent_2023_b.jpg",   "ascent_2023_c.jpg",   "ascent_2023_d.jpg"),   47, null));
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    @GetMapping("/recuperar-password")
    public String recuperarPassword() {
        return "recuperar-password";
    }

    @GetMapping("/marcas")
    public String marcas() {
        return "marcas";
    }

    @GetMapping("/vehiculos")
    public String vehiculos(@RequestParam(value = "marca", required = false) String marca,
                            Model model) {
        model.addAttribute("marca", marca);
        return "vehiculos";
    }

    @GetMapping("/detalle")
    public String detalle(@RequestParam(value = "id", defaultValue = "1") int id,
                          Model model) {
        VehiculoInfo v = CATALOGO.getOrDefault(id, CATALOGO.get(1));
        model.addAttribute("vehiculo", v);
        return "detalle";
    }

    @GetMapping("/como-comprar")
    public String comoComprar() {
        return "como-comprar";
    }
}
