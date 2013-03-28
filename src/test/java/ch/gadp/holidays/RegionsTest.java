/*
 * Copyright (C) 2013  Guy de Pourtalès
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ch.gadp.holidays;

import junit.framework.TestCase;
import org.joda.time.DateMidnight;

import static ch.gadp.holidays.DateTestingHelper.*;


/**
 * Created with IntelliJ IDEA.
 * User: guy
 * Date: 3/22/13
 * Time: 3:06 PM
 */
public class RegionsTest extends TestCase {

    public void testAT() throws Exception {
        testSingleRegionSingleDayHoliday("at", new DateMidnight(2009, 1, 1), "Neujahrstag");
        testSingleRegionSingleDayHoliday("at", new DateMidnight(2009, 4, 13), "Ostermontag");
        testSingleRegionSingleDayHoliday("at", new DateMidnight(2009, 5, 1), "Staatsfeiertag");
        testSingleRegionSingleDayHoliday("at", new DateMidnight(2009, 5, 21), "Christi Himmelfahrt");
        testSingleRegionSingleDayHoliday("at", new DateMidnight(2009, 6, 1), "Pfingstmontag");
        testSingleRegionSingleDayHoliday("at", new DateMidnight(2009, 10, 26), "Nationalfeiertag");
        testSingleRegionSingleDayHoliday("at", new DateMidnight(2009, 12, 25), "1. Weihnachtstag");
        testSingleRegionSingleDayHoliday("at", new DateMidnight(2009, 12, 26), "2. Weihnachtstag");

        testSingleRegionSingleDayNotHoliday("at", new DateMidnight(2010, 5, 8));
    }

    public void testAU() throws Exception {
        testSingleRegionSingleDayHoliday("au", new DateMidnight(2007, 1, 1), "New Year's Day");
        testSingleRegionSingleDayHoliday("au", new DateMidnight(2007, 1, 26), "Australia Day");
        testSingleRegionSingleDayHoliday("au", new DateMidnight(2007, 4, 6), "Good Friday");
        testSingleRegionSingleDayHoliday("au", new DateMidnight(2007, 4, 9), "Easter Monday");
        testSingleRegionSingleDayHoliday("au", new DateMidnight(2007, 4, 25), "ANZAC Day");
        testSingleRegionSingleDayHoliday("au", new DateMidnight(2007, 12, 25), "Christmas Day");
        testSingleRegionSingleDayHoliday("au", new DateMidnight(2007, 12, 26), "Boxing Day");

        testMultipleRegionsSingleDayHoliday(new String[]{"au_sa", "au_nsw", "au_"},
                new DateMidnight(2007, 10, 01), "Labour Day");

        testMultipleRegionsSingleDayHoliday(new String[]{"au_sa", "au_act", "au_nsw", "au_vic", "au_tas", "au_qld", "au_nt", "au_"},
                new DateMidnight(2007, 6, 11), "Queen's Birthday");

        testSingleRegionSingleDayHoliday("au_wa", new DateMidnight(2007, 3, 5), "Labour Day");
        testSingleRegionSingleDayHoliday("au_vic", new DateMidnight(2007, 3, 12), "Labour Day");
        testSingleRegionSingleDayHoliday("au_qld", new DateMidnight(2007, 5, 7), "Labour Day");

        testSingleRegionSingleDayHoliday("au_nt", new DateMidnight(2007, 5, 7), "May Day");

        testSingleRegionSingleDayHoliday("au_tas", new DateMidnight(2007, 3, 12), "Eight Hours Day");
    }

    public void testBR() throws Exception {
        String test = new String("Dia da Confraternização Universal");
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2008, 1, 1), test);
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2005, 2, 8), "Carnaval", Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2006, 2, 28), "Carnaval", Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2007, 2, 20), "Carnaval", Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2008, 2, 5), "Carnaval", Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2008, 3, 21), "Sexta-feira Santa");
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2008, 3, 23), "Páscoa");
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2008, 4, 21), "Dia de Tiradentes");
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2008, 5, 1), "Dia do Trabalho");
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2005, 5, 26), "Corpus Christ");
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2007, 6, 7), "Corpus Christ");
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2008, 5, 22), "Corpus Christ");
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2008, 9, 7), "Proclamação da Independência");
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2008, 10, 12), "Dia de Nossa Senhora Aparecida");
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2008, 11, 2), "Dia de Finados");
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2008, 11, 15), "Proclamação da República");
        testSingleRegionSingleDayHoliday("br", new DateMidnight(2008, 12, 25), "Natal");
    }

    public void testCA() throws Exception {
        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2008, 1, 1), "New Year's Day");
        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2008, 3, 21), "Good Friday");
        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2008, 3, 24), "Easter Monday", Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2008, 5, 19), "Victoria Day");
        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2008, 7, 1), "Canada Day");
        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2008, 9, 1), "Labour Day");
        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2008, 10, 13), "Thanksgiving");
        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2008, 11, 11), "Remembrance Day");
        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2008, 12, 25), "Christmas Day");
        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2008, 12, 26), "Boxing Day");

        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2004, 5, 24), "Victoria Day");
        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2005, 5, 23), "Victoria Day");
        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2006, 5, 22), "Victoria Day");
        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2007, 5, 21), "Victoria Day");
        testSingleRegionSingleDayHoliday("ca", new DateMidnight(2008, 5, 19), "Victoria Day");
    }

    public void testCH() throws Exception {
        testSingleRegionSingleDayHoliday("ch", new DateMidnight(2012, 8, 1), "Bundesfeiertag");
        testSingleRegionSingleDayHoliday("ch", new DateMidnight(2012, 12, 25), "Weihnachten");
        testSingleRegionSingleDayHoliday("ch", new DateMidnight(2012, 05, 17), "Auffahrt");

        testSingleRegionSingleDayHoliday("ch_zh", new DateMidnight(2012, 8, 1), "Bundesfeiertag");
        testSingleRegionSingleDayHoliday("ch_zh", new DateMidnight(2012, 12, 25), "Weihnachten");
        testSingleRegionSingleDayHoliday("ch_zh", new DateMidnight(2012, 5, 17), "Auffahrt");
        testSingleRegionSingleDayHoliday("ch_zh", new DateMidnight(2012, 5, 1), "Tag der Arbeit");
        testSingleRegionSingleDayHoliday("ch_zh", new DateMidnight(2012, 12, 26), "Stefanstag");

        testSingleRegionSingleDayHoliday("ch_vd", new DateMidnight(2012, 9, 17), "Lundi du Jeûne fédéral");
        testSingleRegionSingleDayHoliday("ch_vd", new DateMidnight(2013, 9, 16), "Lundi du Jeûne fédéral");
        testSingleRegionSingleDayHoliday("ch_vd", new DateMidnight(2014, 9, 22), "Lundi du Jeûne fédéral");

        testSingleRegionSingleDayHoliday("ch_ge", new DateMidnight(2012, 9, 6), "Jeûne genevois");
        testSingleRegionSingleDayHoliday("ch_ge", new DateMidnight(2013, 9, 5), "Jeûne genevois");
        testSingleRegionSingleDayHoliday("ch_ge", new DateMidnight(2014, 9, 11), "Jeûne genevois");

        testSingleRegionSingleDayHoliday("ch_gl", new DateMidnight(2012, 4, 12), "Näfelser Fahrt");
        testSingleRegionSingleDayHoliday("ch_gl", new DateMidnight(2013, 4, 4), "Näfelser Fahrt");
        testSingleRegionSingleDayHoliday("ch_gl", new DateMidnight(2014, 4, 3), "Näfelser Fahrt");
    }


    public void testCZ() throws Exception {
        testSingleRegionSingleDayHoliday("cz", new DateMidnight(2010, 1, 1), "Den obnovy samostatného českého státu");
        testSingleRegionSingleDayHoliday("cz", new DateMidnight(2010, 4, 5), "Velikonoční pondělí");
        testSingleRegionSingleDayHoliday("cz", new DateMidnight(2010, 5, 1), "Svátek práce");
        testSingleRegionSingleDayHoliday("cz", new DateMidnight(2010, 5, 8), "Den vítězství");
        testSingleRegionSingleDayHoliday("cz", new DateMidnight(2012, 7, 5), "Den slovanských věrozvěstů Cyrila a Metoděje");
        testSingleRegionSingleDayHoliday("cz", new DateMidnight(2012, 7, 6), "Den upálení mistra Jana Husa");
        testSingleRegionSingleDayHoliday("cz", new DateMidnight(2012, 9, 28), "Den české státnosti");
        testSingleRegionSingleDayHoliday("cz", new DateMidnight(2012, 10, 28), "Den vzniku samostatného československého státu");
        testSingleRegionSingleDayHoliday("cz", new DateMidnight(2012, 11, 17), "Den boje za svobodu a demokracii");
        testSingleRegionSingleDayHoliday("cz", new DateMidnight(2012, 12, 24), "Štědrý den");
        testSingleRegionSingleDayHoliday("cz", new DateMidnight(2012, 12, 25), "1. svátek vánoční");
        testSingleRegionSingleDayHoliday("cz", new DateMidnight(2012, 12, 26), "2. svátek vánoční");
    }

    public void testDE() throws Exception {
        testSingleRegionSingleDayHoliday("de", new DateMidnight(2009, 1, 1), "Neujahrstag");
        testSingleRegionSingleDayHoliday("de", new DateMidnight(2009, 4, 10), "Karfreitag");
        testSingleRegionSingleDayHoliday("de", new DateMidnight(2009, 4, 13), "Ostermontag");
        testSingleRegionSingleDayHoliday("de", new DateMidnight(2009, 5, 1), "Tag der Arbeit");
        testSingleRegionSingleDayHoliday("de", new DateMidnight(2009, 5, 21), "Christi Himmelfahrt");
        testSingleRegionSingleDayHoliday("de", new DateMidnight(2009, 6, 1), "Pfingstmontag");
        testSingleRegionSingleDayHoliday("de", new DateMidnight(2009, 10, 3), "Tag der Deutschen Einheit");
        testSingleRegionSingleDayHoliday("de", new DateMidnight(2009, 12, 25), "1. Weihnachtstag");
        testSingleRegionSingleDayHoliday("de", new DateMidnight(2009, 12, 26), "2. Weihnachtstag");

        testMultipleRegionsSingleDayHoliday(new String[]{"de_bw", "de_by", "de_st", "de_"},
                new DateMidnight(2009, 1, 6), "Heilige Drei Könige");

        testMultipleRegionsSingleDayHoliday(new String[]{"de_bw", "de_by", "de_he", "de_nw", "de_rp", "de_sl", "de_"},
                new DateMidnight(2009, 6, 11), "Fronleichnam");

        testMultipleRegionsSingleDayHoliday(new String[]{"de_by", "de_sl", "de_"},
                new DateMidnight(2009, 8, 15), "Mariä Himmelfahrt");

        testMultipleRegionsSingleDayHoliday(new String[]{"de_bb", "de_mv", "de_sn", "de_st", "de_th", "de_"},
                new DateMidnight(2009, 10, 31), "Reformationstag");

        testMultipleRegionsSingleDayHoliday(new String[]{"de_bw", "de_by", "de_nw", "de_rp", "de_sl", "de_"},
                new DateMidnight(2009, 11, 1), "Allerheiligen");

        testSingleRegionSingleDayNotHoliday("de", new DateMidnight(2010, 05, 8));

        testSingleRegionSingleDayHoliday("de_sn", new DateMidnight(2004, 11, 17), "Buß- und Bettag");
        testSingleRegionSingleDayHoliday("de_sn", new DateMidnight(2005, 11, 16), "Buß- und Bettag");
        testSingleRegionSingleDayHoliday("de_sn", new DateMidnight(2006, 11, 22), "Buß- und Bettag");
        testSingleRegionSingleDayHoliday("de_sn", new DateMidnight(2009, 11, 18), "Buß- und Bettag");
    }

    public void testDK() throws Exception {
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 1, 1), "Nytårsdag");
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 2, 18), "Fastelavn", Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 4, 9), "Danmarks besættelse", Holidays.INFORMAL, 2);
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 4, 16), "Dronningens fødselsdag", Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 4, 5), "Skærtorsdag");
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 4, 6), "Langfredag");
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 4, 8), "Påskedag");
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 4, 9), "2. påskedag");
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 5, 1), "Arbejdernes kampdag");
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 5, 4), "Store Bededag");
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 5, 17), "Kristi Himmelfartsdag");
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 5, 27), "Pinsedag");
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 5, 28), "2. Pinsedag");
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 6, 5), "Grundlovsdag");
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 12, 24), "Juleaftensdag");
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 12, 25), "1. juledag");
        testSingleRegionSingleDayHoliday("dk", new DateMidnight(2007, 12, 26), "2. juledag");
    }

    public void testEL() throws Exception {
        testSingleRegionSingleDayHoliday("el", new DateMidnight(2011, 1, 1), "Πρωτοχρονιά");
        testSingleRegionSingleDayHoliday("el", new DateMidnight(2011, 1, 6), "Θεοφάνεια");
        testSingleRegionSingleDayHoliday("el", new DateMidnight(2011, 4, 22), "Μεγάλη Παρασκευή");
        testSingleRegionSingleDayHoliday("el", new DateMidnight(1970, 4, 25), "Μεγάλο Σάββατο");
        testSingleRegionSingleDayHoliday("el", new DateMidnight(1985, 4, 14), "Κυριακή του Πάσχα");
        testSingleRegionSingleDayHoliday("el", new DateMidnight(2011, 4, 24), "Κυριακή του Πάσχα");
        testSingleRegionSingleDayHoliday("el", new DateMidnight(2027, 5, 2), "Κυριακή του Πάσχα");
        testSingleRegionSingleDayHoliday("el", new DateMidnight(2046, 4, 30), "Δευτέρα του Πάσχα");
        testSingleRegionSingleDayHoliday("el", new DateMidnight(2011, 5, 1), "Πρωτομαγιά");
        testSingleRegionSingleDayHoliday("el", new DateMidnight(2011, 6, 13), "Αγίου Πνεύματος");
        testSingleRegionSingleDayHoliday("el", new DateMidnight(2012, 6, 4), "Αγίου Πνεύματος");
        testSingleRegionSingleDayHoliday("el", new DateMidnight(2011, 3, 7), "Καθαρά Δευτέρα");
        testSingleRegionSingleDayHoliday("el", new DateMidnight(2012, 2, 27), "Καθαρά Δευτέρα");
        testSingleRegionSingleDayHoliday("el", new DateMidnight(2011, 12, 25), "Χριστούγεννα");
        testSingleRegionSingleDayHoliday("el", new DateMidnight(2011, 12, 26), "Δεύτερη ημέρα των Χριστουγέννων");
    }

    public void testES() throws Exception {
        testSingleRegionSingleDayHoliday("es", new DateMidnight(2009, 1, 1), "Año Nuevo");
        testSingleRegionSingleDayHoliday("es", new DateMidnight(2009, 1, 6), "Día de Reyes");
        testSingleRegionSingleDayHoliday("es", new DateMidnight(2009, 4, 10), "Viernes Santo");
        testSingleRegionSingleDayHoliday("es", new DateMidnight(2009, 5, 1), "Día del Trabajador");
        testSingleRegionSingleDayHoliday("es", new DateMidnight(2009, 8, 15), "Asunción");
        testSingleRegionSingleDayHoliday("es", new DateMidnight(2009, 10, 12), "Día de la Hispanidad");
        testSingleRegionSingleDayHoliday("es", new DateMidnight(2009, 11, 1), "Todos los Santos");
        testSingleRegionSingleDayHoliday("es", new DateMidnight(2009, 12, 6), "Día de la Constitución");
        testSingleRegionSingleDayHoliday("es", new DateMidnight(2009, 12, 8), "Inmaculada Concepción");
        testSingleRegionSingleDayHoliday("es", new DateMidnight(2009, 12, 25), "Navidad del Señor");

        testMultipleRegionsSingleDayHoliday(new String[]{"es_pv", "es_ct", "es_na", "es_v", "es_vc", "es_"},
                new DateMidnight(2009, 4, 9), "Jueves Santo");

        testMultipleRegionsSingleDayHoliday(new String[]{"es_pv", "es_ct", "es_na", "es_v", "es_vc", "es_"},
                new DateMidnight(2009, 4, 13), "Lunes de Pascua");

        testMultipleRegionsSingleDayHoliday(new String[]{"es_v", "es_vc", "es_cm", "es_mu", "es_m", "es_"},
                new DateMidnight(2009, 3, 19), "San José");

        testMultipleRegionsSingleDayHoliday(new String[]{"es_ar", "es_cl", "es_"},
                new DateMidnight(2009, 4, 23), "San Jorge", 2);

        testMultipleRegionsSingleDayHoliday(new String[]{"es_vc", "es_v", "es_"},
                new DateMidnight(2009, 10, 9), "Día de Valencia");

        testMultipleRegionsSingleDayHoliday(new String[]{"es_ib", "es_ct", "es_"},
                new DateMidnight(2009, 12, 26), "San Esteban");

        testSingleRegionSingleDayHoliday("es_an", new DateMidnight(2009, 2, 28), "Día de Andalucía");
        testSingleRegionSingleDayHoliday("es_ib", new DateMidnight(2009, 3, 1), "Día de las Islas Baleares");
        testSingleRegionSingleDayHoliday("es_m", new DateMidnight(2006, 5, 2), "Fiesta de la Comunidad");
        testSingleRegionSingleDayHoliday("es_cn", new DateMidnight(2006, 5, 30), "Día de las Canarias");
        testSingleRegionSingleDayHoliday("es_cm", new DateMidnight(2009, 5, 31), "Día de la Región Castilla-La Mancha");
        testSingleRegionSingleDayHoliday("es_mu", new DateMidnight(2009, 6, 9), "Día de la Región de Murcia");
        testSingleRegionSingleDayHoliday("es_lo", new DateMidnight(2009, 6, 9), "Día de La Rioja");
        testSingleRegionSingleDayHoliday("es_ga", new DateMidnight(2009, 7, 23), "Santiago Apostol");
        testSingleRegionSingleDayHoliday("es_ce", new DateMidnight(2009, 9, 2), "Día de Ceuta");
        testSingleRegionSingleDayHoliday("es_o", new DateMidnight(2009, 9, 8), "Día de Asturias");
        testSingleRegionSingleDayHoliday("es_ex", new DateMidnight(2009, 9, 8), "Día de Extremadura");
        testSingleRegionSingleDayHoliday("es_ct", new DateMidnight(2009, 9, 11), "Fiesta Nacional de Cataluña");
    }

    public void testFederalReserve() throws Exception {
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2012, 1, 2), "New Year's Day", Holidays.OBSERVED);
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2012, 1, 16), "Birthday of Martin Luther King, Jr");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2012, 2, 20), "Washington's Birthday");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2012, 4, 6), "Good Friday");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2012, 5, 28), "Memorial Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2012, 7, 4), "Independence Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2012, 9, 3), "Labor Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2012, 10, 8), "Columbus Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2012, 11, 12), "Veterans Day", Holidays.OBSERVED);
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2012, 11, 22), "Thanksgiving Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2012, 12, 24), "Christmas Eve");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2012, 12, 25), "Christmas Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2012, 12, 31), "New Year's Eve");

        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2013, 1, 1), "New Year's Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2013, 1, 21), "Birthday of Martin Luther King, Jr");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2013, 2, 18), "Washington's Birthday");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2013, 3, 29), "Good Friday");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2013, 5, 27), "Memorial Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2013, 7, 4), "Independence Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2013, 9, 2), "Labor Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2013, 10, 14), "Columbus Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2013, 11, 11), "Veterans Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2013, 11, 28), "Thanksgiving Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2013, 12, 24), "Christmas Eve");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2013, 12, 25), "Christmas Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2013, 12, 31), "New Year's Eve");

        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2014, 1, 1), "New Year's Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2014, 1, 20), "Birthday of Martin Luther King, Jr");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2014, 2, 17), "Washington's Birthday");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2014, 4, 18), "Good Friday");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2014, 5, 26), "Memorial Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2014, 7, 4), "Independence Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2014, 9, 1), "Labor Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2014, 10, 13), "Columbus Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2014, 11, 11), "Veterans Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2014, 11, 27), "Thanksgiving Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2014, 12, 24), "Christmas Eve");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2014, 12, 25), "Christmas Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2014, 12, 31), "New Year's Eve");

        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2015, 1, 1), "New Year's Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2015, 1, 19), "Birthday of Martin Luther King, Jr");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2015, 2, 16), "Washington's Birthday");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2015, 4, 3), "Good Friday");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2015, 5, 25), "Memorial Day", Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2015, 7, 4), "Independence Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2015, 9, 7), "Labor Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2015, 10, 12), "Columbus Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2015, 11, 11), "Veterans Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2015, 11, 26), "Thanksgiving Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2015, 12, 24), "Christmas Eve");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2015, 12, 25), "Christmas Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2015, 12, 31), "New Year's Eve");

        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2016, 1, 1), "New Year's Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2016, 1, 18), "Birthday of Martin Luther King, Jr");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2016, 2, 15), "Washington's Birthday");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2016, 3, 25), "Good Friday");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2016, 5, 30), "Memorial Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2016, 7, 4), "Independence Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2016, 9, 5), "Labor Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2016, 10, 10), "Columbus Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2016, 11, 11), "Veterans Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2016, 11, 24), "Thanksgiving Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2016, 12, 24), "Christmas Eve");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2016, 12, 25), "Christmas Day");
        testSingleRegionSingleDayHoliday("federal_reserve", new DateMidnight(2016, 12, 31), "New Year's Eve");
    }

    public void testFI() throws Exception {
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2008, 1, 1), "Uudenvuodenpäivä");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2008, 1, 6), "Loppiainen");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2008, 3, 21), "Pitkäperjantai");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2008, 3, 23), "Pääsiäispäivä");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2008, 3, 24), "2. Pääsiäispäivä");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2008, 5, 1), "Vappu", Holidays.NO_OPTION, 2);
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2008, 5, 1), "Helatorstai", Holidays.NO_OPTION, 2);
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2008, 5, 11), "Helluntaipäivä");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2005, 6, 25), "Juhannuspäivä");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2006, 6, 24), "Juhannuspäivä");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2007, 6, 23), "Juhannuspäivä");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2008, 6, 21), "Juhannuspäivä");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2005, 11, 5), "Pyhäinpäivä");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2006, 11, 4), "Pyhäinpäivä");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2007, 11, 3), "Pyhäinpäivä");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2008, 11, 1), "Pyhäinpäivä");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2008, 12, 6), "Itsenäisyyspäivä");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2008, 12, 24), "Jouluaatto");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2008, 12, 25), "Joulupäivä");
        testSingleRegionSingleDayHoliday("fi", new DateMidnight(2008, 12, 26), "Tapaninpäivä");
    }


    public void testFR() throws Exception {
        testSingleRegionSingleDayHoliday("fr", new DateMidnight(2007, 1, 1), "Jour de l'an");
        testSingleRegionSingleDayHoliday("fr", new DateMidnight(2007, 4, 8), "Pâques");
        testSingleRegionSingleDayHoliday("fr", new DateMidnight(2007, 4, 9), "Lundi de Pâques");
        testSingleRegionSingleDayHoliday("fr", new DateMidnight(2007, 5, 1), "Fête du travail");
        testSingleRegionSingleDayHoliday("fr", new DateMidnight(2007, 5, 8), "Victoire 1945");
        testSingleRegionSingleDayHoliday("fr", new DateMidnight(2007, 5, 17), "Ascension");
        testSingleRegionSingleDayHoliday("fr", new DateMidnight(2007, 5, 27), "Pentecôte");
        testSingleRegionSingleDayHoliday("fr", new DateMidnight(2007, 5, 28), "Lundi de Pentecôte");
        testSingleRegionSingleDayHoliday("fr", new DateMidnight(2007, 7, 14), "Fête nationale");
        testSingleRegionSingleDayHoliday("fr", new DateMidnight(2007, 8, 15), "Assomption");
        testSingleRegionSingleDayHoliday("fr", new DateMidnight(2007, 11, 1), "Toussaint");
        testSingleRegionSingleDayHoliday("fr", new DateMidnight(2007, 11, 11), "Armistice 1918");
        testSingleRegionSingleDayHoliday("fr", new DateMidnight(2007, 12, 25), "Noël");
    }

    public void testGB() throws Exception {
        testSingleRegionSingleDayHoliday("gb", new DateMidnight(2008, 1, 1), "New Year's Day");
        testSingleRegionSingleDayHoliday("gb", new DateMidnight(2008, 3, 21), "Good Friday");
        testSingleRegionSingleDayHoliday("gb", new DateMidnight(2008, 3, 23), "Easter Sunday");
        testSingleRegionSingleDayHoliday("gb", new DateMidnight(2008, 5, 5), "May Day");
        testSingleRegionSingleDayHoliday("gb", new DateMidnight(2008, 5, 26), "Bank Holiday");
        testSingleRegionSingleDayHoliday("gb", new DateMidnight(2008, 11, 5), "Guy Fawkes Day", Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("gb", new DateMidnight(2008, 12, 25), "Christmas Day");
        testSingleRegionSingleDayHoliday("gb", new DateMidnight(2008, 12, 26), "Boxing Day");

        testSingleRegionSingleDayHoliday("gb_nir", new DateMidnight(2008, 3, 17), "St. Patrick's Day", Holidays.INFORMAL);

        testSingleRegionSingleDayHoliday("gb_", new DateMidnight(2008, 12, 26), "Boxing Day", Holidays.OBSERVED);
        testSingleRegionSingleDayHoliday("gb_", new DateMidnight(2009, 12, 28), "Boxing Day", Holidays.OBSERVED);
        testSingleRegionSingleDayHoliday("gb_", new DateMidnight(2010, 12, 28), "Boxing Day", Holidays.OBSERVED);

        testMultipleRegionsSingleDayHoliday(new String[]{"gb_wls", "gb_eng", "gb_nir", "gb_eaw", "gb_"},
                new DateMidnight(2008, 3, 24), "Easter Monday");

        testMultipleRegionsSingleDayHoliday(new String[]{"gb_wls", "gb_eng", "gb_nir", "gb_eaw", "gb_"},
                new DateMidnight(2008, 8, 25), "Bank Holiday");
    }

    public void testHR() throws Exception {
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2012, 1, 1), "Nova godina");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2012, 1, 6), "Sveta tri kralja");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2012, 5, 1), "Međunarodni praznik rada");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2012, 6, 22), "Dan antifašističke borbe");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2012, 6, 25), "Dan državnosti");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2012, 8, 5), "Dan pobjede i domovinske zahvalnosti i dan hrvatskih branitelja");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2012, 8, 15), "Velika Gospa");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2012, 10, 8), "Dan neovisnosti");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2012, 11, 1), "Dan svih svetih");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2012, 12, 25), "Božić");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2012, 12, 26), "Sveti Stjepan");

        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2008, 5, 22), "Tijelovo");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2009, 6, 11), "Tijelovo");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2010, 6, 3), "Tijelovo");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2012, 6, 7), "Tijelovo");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2013, 5, 30), "Tijelovo");
        testSingleRegionSingleDayHoliday("hr", new DateMidnight(2014, 6, 19), "Tijelovo");
    }

    public void testHU() throws Exception {
        testSingleRegionSingleDayHoliday("hu", new DateMidnight(2012, 1, 1), "Újév");
        testSingleRegionSingleDayHoliday("hu", new DateMidnight(2011, 1, 1), "Újév");
        testSingleRegionSingleDayHoliday("hu", new DateMidnight(2012, 3, 15), "1848/49-es forradalom és szabadságharc ünnepe");
        testSingleRegionSingleDayHoliday("hu", new DateMidnight(2011, 4, 25), "Húsvét hétfő");
        testSingleRegionSingleDayHoliday("hu", new DateMidnight(2012, 4, 9), "Húsvét hétfő");
        testSingleRegionSingleDayHoliday("hu", new DateMidnight(2012, 5, 1), "A munka ünnepe");
        testSingleRegionSingleDayHoliday("hu", new DateMidnight(2011, 6, 13), "Pünkösd hétfő");
        testSingleRegionSingleDayHoliday("hu", new DateMidnight(2012, 5, 28), "Pünkösd hétfő");
        testSingleRegionSingleDayHoliday("hu", new DateMidnight(2012, 8, 20), "Az államalapítás ünnepe");
        testSingleRegionSingleDayHoliday("hu", new DateMidnight(2012, 8, 20), "Az államalapítás ünnepe");
        testSingleRegionSingleDayHoliday("hu", new DateMidnight(2012, 10, 23), "1956-os forradalom és szabadságharc ünnepe");
        testSingleRegionSingleDayHoliday("hu", new DateMidnight(2012, 11, 1), "Mindenszentek");
        testSingleRegionSingleDayHoliday("hu", new DateMidnight(2012, 12, 25), "Karácsony");
        testSingleRegionSingleDayHoliday("hu", new DateMidnight(2012, 12, 26), "Karácsony");

        testSingleRegionSingleDayNotHoliday("hu", new DateMidnight(2012, 3, 14));
    }

    public void testIE() throws Exception {
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2008, 1, 1), "New Year's Day");
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2008, 3, 17), "St. Patrick's Day");
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2008, 3, 24), "Easter Monday");
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2008, 5, 5), "May Day");
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2008, 6, 2), "June Bank Holiday");
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2008, 8, 4), "August Bank Holiday");
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2008, 10, 27), "October Bank Holiday");
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2008, 12, 25), "Christmas Day");
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2008, 12, 26), "St. Stephen's Day");

        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2012, 1, 2), "New Year's Day", Holidays.OBSERVED);
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2012, 3, 19), "St. Patrick's Day", Holidays.OBSERVED);
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2012, 4, 9), "Easter Monday", Holidays.OBSERVED);
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2012, 5, 7), "May Day", Holidays.OBSERVED);
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2012, 6, 4), "June Bank Holiday", Holidays.OBSERVED);
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2012, 8, 6), "August Bank Holiday", Holidays.OBSERVED);
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2012, 10, 29), "October Bank Holiday", Holidays.OBSERVED);
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2011, 12, 26), "Christmas Day", Holidays.OBSERVED);
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2011, 12, 27), "St. Stephen's Day", Holidays.OBSERVED);
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2012, 12, 25), "Christmas Day", Holidays.OBSERVED);
        testSingleRegionSingleDayHoliday("ie", new DateMidnight(2012, 12, 26), "St. Stephen's Day", Holidays.OBSERVED);
    }

    public void testIS() throws Exception {
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 1, 1), "Nýársdagur");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 1, 6), "Þrettándinn");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 1, 19), "Bóndadagur", Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 2, 18), "Konudagur",  Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 4, 5), "Skírdagur");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 4, 6), "Föstudaginn langi");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 4, 8), "Páskadagur");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 4, 9), "Annar í páskum");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 4, 19), "Sumardagurinn fyrsti");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 5, 1), "Verkalýðsdagurinn");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 5, 17), "Uppstigningardagur");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 5, 27), "Hvítasunnudagur");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 5, 28), "Annar í hvítasunnu");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 6, 3), "Sjómannadagurinn",  Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 6, 17), "Lýðveldisdagurinn");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 8, 6), "Frídagur verslunarmanna");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 12, 24), "Jól");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 12, 25), "Jól");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 12, 26), "Jól");
        testSingleRegionSingleDayHoliday("is", new DateMidnight(2007, 12, 31), "Gamlárskvöld");
    }

    public void testIT() throws Exception {
        testSingleRegionSingleDayHoliday("it", new DateMidnight(2007, 1, 1), "Capodanno");
        testSingleRegionSingleDayHoliday("it", new DateMidnight(2007, 1, 6), "Epifania");
        testSingleRegionSingleDayHoliday("it", new DateMidnight(2007, 4, 8), "Pasqua");
        testSingleRegionSingleDayHoliday("it", new DateMidnight(2007, 4, 9), "Lunedì dell'Angelo");
        testSingleRegionSingleDayHoliday("it", new DateMidnight(2007, 4, 25), "Festa della Liberazione");
        testSingleRegionSingleDayHoliday("it", new DateMidnight(2007, 5, 1), "Festa dei Lavoratori");
        testSingleRegionSingleDayHoliday("it", new DateMidnight(2007, 6, 2), "Festa della Repubblica");
        testSingleRegionSingleDayHoliday("it", new DateMidnight(2007, 8, 15), "Assunzione");
        testSingleRegionSingleDayHoliday("it", new DateMidnight(2007, 11, 1), "Ognissanti");
        testSingleRegionSingleDayHoliday("it", new DateMidnight(2007, 12, 8), "Immacolata Concezione");
        testSingleRegionSingleDayHoliday("it", new DateMidnight(2007, 12, 25), "Natale");
        testSingleRegionSingleDayHoliday("it", new DateMidnight(2007, 12, 26), "Santo Stefano");
    }

    public void testJP() throws Exception {
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2008, 1, 1), "元日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2010, 1, 11), "成人の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2008, 2, 11), "建国記念日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2008, 4, 29), "昭和の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2008, 5, 3), "憲法記念日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2008, 5, 5), "こどもの日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2010, 7, 19), "海の日", Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2010, 9, 20), "敬老の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2010, 10, 11), "体育の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2008, 11, 3), "文化の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2008, 11, 23), "勤労感謝の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2008, 12, 23), "天皇誕生日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2010, 3, 22), "振替休日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2008, 11, 24), "振替休日");

        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2004, 3, 20), "春分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2005, 3, 20), "春分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2006, 3, 21), "春分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2007, 3, 21), "春分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2008, 3, 20), "春分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2009, 3, 20), "春分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2010, 3, 21), "春分の日");

        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2004, 9, 23), "秋分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2005, 9, 23), "秋分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2006, 9, 23), "秋分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2007, 9, 23), "秋分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2008, 9, 23), "秋分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2009, 9, 23), "秋分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2010, 9, 23), "秋分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2011, 9, 23), "秋分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2012, 9, 22), "秋分の日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2013, 9, 23), "秋分の日");

        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2032, 9, 21), "国民の休日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2049, 9, 21), "国民の休日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2009, 9, 22), "国民の休日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2015, 9, 22), "国民の休日");
        testSingleRegionSingleDayHoliday("jp", new DateMidnight(2026, 9, 22), "国民の休日");
    }

    public void testLI() throws Exception {
        testSingleRegionSingleDayHoliday("li", new DateMidnight(2012, 1, 1), "Neujahrstag");
        testSingleRegionSingleDayHoliday("li", new DateMidnight(2012, 1, 6), "Heilige Drei Könige");
        testSingleRegionSingleDayHoliday("li", new DateMidnight(2012, 2, 2), "Maria Lichtmess");
        testSingleRegionSingleDayHoliday("li", new DateMidnight(2012, 3, 19), "St. Josef");
        testSingleRegionSingleDayHoliday("li", new DateMidnight(2012, 5, 1), "Tag der Arbeit");
        testSingleRegionSingleDayHoliday("li", new DateMidnight(2012, 9, 8), "Maria Geburt");
        testSingleRegionSingleDayHoliday("li", new DateMidnight(2012, 12, 8), "Maria Empfängnis");
    }

    public void testMX() throws Exception {
        testSingleRegionSingleDayHoliday("mx", new DateMidnight(2012, 1, 1), "Año nuevo");
        testSingleRegionSingleDayHoliday("mx", new DateMidnight(2012, 1, 6), "Dia de los Santos Reyes");
        testSingleRegionSingleDayHoliday("mx", new DateMidnight(2012, 4, 30), "Día del Niño",  Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("mx", new DateMidnight(2012, 9, 15), "Grito de Dolores",  Holidays.INFORMAL);
        testSingleRegionSingleDayHoliday("mx", new DateMidnight(2012, 9, 16), "Día de la Independencia",  Holidays.INFORMAL);
    }
}
