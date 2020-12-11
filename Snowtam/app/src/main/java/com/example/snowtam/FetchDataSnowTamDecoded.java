package com.example.snowtam;

import android.util.Log;

import java.util.ArrayList;

public class FetchDataSnowTamDecoded {

    ArrayList<String> Alphabets = new ArrayList<String>();


    public String SnowtamDecoded(String fetchedSnowtam) {

        fetchedSnowtam = removeLines(fetchedSnowtam);


        String SnowtamDecoded = "";
        for (int i = 0; i < 20; i++) {
            Alphabets.add("");
        }

        int i = 0;

        String s = fetchedSnowtam;

        String[] split = null;
        if (s.contains("A)")) {
            split = s.split("A\\)");
            Alphabets.set(i, split[1]);
            i = 0;
        }

        if (split[1].contains("B)")) {
            split = split[1].split("B\\)");
            Alphabets.set(i, split[0]);
            i = 1;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("C)")) {
            split = split[1].split("C\\)");
            Alphabets.set(i, split[0]);
            i = 2;
            Alphabets.set(i, split[1]);
        }



        if (split[1].contains("D)")) {
            split = split[1].split("D\\)");
            Alphabets.set(i, split[0]);
            i = 3;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("E)")) {
            split = split[1].split("E\\)");
            Alphabets.set(i, split[0]);
            i = 4;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("F)")) {
            split = split[1].split("F\\)");
            Alphabets.set(i, split[0]);
            i = 5;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("G)")) {
            split = split[1].split("G\\)");
            Alphabets.set(i, split[0]);
            i = 6;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("H)")) {
            split = split[1].split("H\\)");
            Alphabets.set(i, split[0]);
            i = 7;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("I)")) {
            split = split[1].split("I\\)");
            Alphabets.set(i, split[0]);
            i = 8;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("J)")) {
            split = split[1].split("J\\)");
            Alphabets.set(i, split[0]);
            i = 9;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("K)")) {
            split = split[1].split("K\\)");
            Alphabets.set(i, split[0]);
            i = 10;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("L)")) {
            split = split[1].split("L\\)");
            Alphabets.set(i, split[0]);
            i = 11;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("M)")) {
            split = split[1].split("M\\)");
            Alphabets.set(i, split[0]);
            i = 12;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("N)")) {
            split = split[1].split("N\\)");
            Alphabets.set(i, split[0]);
            i = 13;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("O)")) {
            split = split[1].split("O\\)");
            Alphabets.set(i, split[0]);
            i = 14;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("P)")) {
            split = split[1].split("P\\)");
            Alphabets.set(i, split[0]);
            i = 15;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("Q)")) {
            split = split[1].split("Q\\)");
            Alphabets.set(i, split[0]);
            i = 16;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("R)")) {
            split = split[1].split("R\\)");
            Alphabets.set(i, split[0]);
            i = 17;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("S)")) {
            split = split[1].split("S\\)");
            Alphabets.set(i, split[0]);
            i = 18;
            Alphabets.set(i, split[1]);
        }


        if (split[1].contains("T)")) {
            split = split[1].split("T\\)");
            Alphabets.set(i, split[0]);
            i = 19;
            Alphabets.set(i, split[1]);
        } else

            {
            Log.e("NO RESULT", " Can't be decoded");
        }





        if (Alphabets.get(0) != "") {
            SnowtamDecoded += "* Aerodrome : " + Alphabets.get(0);
            SnowtamDecoded += "\n \n";
        }

        String time = "";

        if (Alphabets.get(1) != "") {
            time = removeSpace(Alphabets.get(1));
            String day = time.substring(2, 4);
            SnowtamDecoded += "* Date/Time of Oservation: " + day + " ";
            String month = time.substring(0, 2);
            month = getMonth(Integer.valueOf(month));
            SnowtamDecoded += month + ", ";
            String hour = time.substring(4, 6);
            String minutes = time.substring(6, 8);
            SnowtamDecoded += hour + "H" + minutes + " UTC";
            SnowtamDecoded += "\n \n";
        }


        if (Alphabets.get(2) != "") {
            SnowtamDecoded += "* Runway Designators: " + Alphabets.get(2);
            SnowtamDecoded += "\n \n";
        }


        if (Alphabets.get(3) != "") {
            SnowtamDecoded += "* Cleared Runway Length  " + Alphabets.get(3) + "M";
            SnowtamDecoded += "\n \n";
        }
        if (Alphabets.get(4) != "") {
            SnowtamDecoded += "* Cleared Runway Width " + Alphabets.get(4) + "M";
            if (Alphabets.get(4).contains("L")) {
                SnowtamDecoded += " left";
            } else if (Alphabets.get(4).contains("R")) {
                SnowtamDecoded += " right";
            }
            SnowtamDecoded += "\n \n";
        }

        if (Alphabets.get(5) != "") {
            String[] conds = Alphabets.get(5).split("/");
            SnowtamDecoded += "* Deposits over total Runway Length: ";
            SnowtamDecoded += getConditions(conds[0]);
            SnowtamDecoded += " / Mid runway: ";
            SnowtamDecoded += getConditions(conds[1]);
            SnowtamDecoded += " / Roll out: ";
            SnowtamDecoded += getConditions(conds[2]);
            SnowtamDecoded += "\n \n";
        }

        if (Alphabets.get(6) != "") {
            String[] conds = removeSpace(Alphabets.get(6)).split("/");
            SnowtamDecoded += "* Mean Depth(mm): ";
            SnowtamDecoded += conds[0];
            SnowtamDecoded += "mm / Mid runway: ";
            SnowtamDecoded += conds[1];
            SnowtamDecoded += "mm / Roll out: ";
            SnowtamDecoded += conds[2] + "mm";
            SnowtamDecoded += "\n \n";
        }

        if (Alphabets.get(7) != "") {
            String[] conds = Alphabets.get(7).split("/");
            SnowtamDecoded += "* Breaking action: ";
            SnowtamDecoded += getCoeff(conds[0]);
            SnowtamDecoded += " / Mid runway: ";
            SnowtamDecoded += getCoeff(conds[1]);
            if (conds[2].contains(" ") && !conds[2].contains(")")) {
                String[] x = conds[2].split(" ");
                SnowtamDecoded += " / Roll out: ";
                SnowtamDecoded += getCoeff(x[0]);
                SnowtamDecoded += "\nInstrument: " + x[1];
            } else if (conds[2].length() > 0) {
                SnowtamDecoded += " / Roll out: ";
                SnowtamDecoded += getCoeff(conds[2].substring(0, 1));
            }
            SnowtamDecoded += "\n \n";
        }

        if (Alphabets.get(9) != "") {
            String[] conds = Alphabets.get(9).split("/");
            SnowtamDecoded += "* Critical Snowbanks : ";
            SnowtamDecoded += conds[0] + "cm / ";
            if (conds[1].contains("L") && !conds[1].contains("LR")) {
                conds = conds[1].split("L");
                SnowtamDecoded += conds[0] + "m left of Runway";
            } else if (conds[1].contains("R") && !conds[1].contains("LR")) {
                conds = conds[1].split("R");
                SnowtamDecoded += conds[0] + "m right of Runway";
            } else if (conds[1].contains("LR")) {
                conds = conds[1].split("LR");
                SnowtamDecoded += conds[0] + "m right and left of Runway";
            }
            SnowtamDecoded += "\n \n";
        }

        if (Alphabets.get(10) != "") {
            if (Alphabets.get(10).contains("YES")) {
                String[] conds = Alphabets.get(10).split("S ");
                SnowtamDecoded += "* Runway Lights: YES ";
                if (conds[1].contains("L") && !conds[1].contains("LR")) {
                    SnowtamDecoded += "left of Runway";
                } else if (conds[1].contains("R") && !conds[1].contains("LR")) {
                    SnowtamDecoded += "left of Runway";
                } else if (conds[1].contains("LR")) {
                    SnowtamDecoded += "Right and left of Runway";
                }
            } else if (Alphabets.get(10).contains("NO")) {
                String[] conds = Alphabets.get(10).split("O ");
                SnowtamDecoded += "* Runway Lights: NO ";
                if (conds[1].contains("L") && !conds[1].contains("LR")) {
                    SnowtamDecoded += "LEFT of Runway";
                } else if (conds[1].contains("R") && !conds[1].contains("LR")) {
                    SnowtamDecoded += "Right of Runway";
                } else if (conds[1].contains("LR")) {
                    SnowtamDecoded += "RIGHT and LEFT of Runway";
                }
            }
            SnowtamDecoded += "\n \n";
        }


        if (Alphabets.get(11) != "") {
            if (Alphabets.get(11).contains("/")) {
                String[] longs = Alphabets.get(11).split("/");
                SnowtamDecoded += "* Further clearance: " + longs[0] + "m / " + removeSpace(longs[1]) + "m";
            } else if (Alphabets.get(11).contains("TOTAL")) {
                SnowtamDecoded += "" + "Further Clearance TOTAL";
            }
            SnowtamDecoded += "\n \n";
        }

        if (Alphabets.get(12) != "") {
            SnowtamDecoded += "* Further Clearance To be Completed by: " + removeSpace(Alphabets.get(12)) + " UTC";
            SnowtamDecoded += "\n \n";
        }

        if (Alphabets.get(13) != "") {
            SnowtamDecoded += "* Taxiway: " + Alphabets.get(13);
            SnowtamDecoded += "\n \n";
        }

        if (Alphabets.get(15) != "") {
            if (Alphabets.get(15).contains("YES")) {
                String[] conds = Alphabets.get(15).split("S");
                SnowtamDecoded += "* Taxiway Snowbanks : YES " + conds[1] + "m";
            }
            SnowtamDecoded += "\n \n";
        }

        if (Alphabets.get(17) != "") {
            SnowtamDecoded += "* APRON: " + Alphabets.get(17);
            SnowtamDecoded += "\n \n";
        }

        if (Alphabets.get(18) != "") {
            time = removeSpace(Alphabets.get(18));
            String day = time.substring(2, 4);
            SnowtamDecoded += "Next Planned Observation " + day + " ";
            String month = time.substring(0, 2);
            month = getMonth(Integer.valueOf(month));
            SnowtamDecoded += month + " at ";
            String hour = time.substring(4, 6);
            String minutes = time.substring(6, 8);
            SnowtamDecoded += hour + "H" + minutes + "UTC";
            SnowtamDecoded += "\n \n";
        }

        if (Alphabets.get(19) != "") {
            String tmp = Alphabets.get(19).replaceAll("Plain Language Remarks: ", " Plain Language Remarks: ");
            tmp = tmp.replaceAll("RWY", "runway");
            tmp = tmp.replaceAll("OBSERVATION", "\nobservation : ");
            tmp = tmp.replaceAll("\\.", ".\n");
            tmp = tmp.replaceAll("100", "51–100%");
            tmp = tmp.replaceAll("50", "26–50%");
            tmp = tmp.replaceAll("25", "11–25%");
            tmp = tmp.replaceAll("PERCENT", "");
            SnowtamDecoded += "* " + tmp;
            SnowtamDecoded += "\n \n";
        }

        String[] str = SnowtamDecoded.split("CREATED");
        SnowtamDecoded = str[0];
        return SnowtamDecoded;


    }

    private String getConditions(String nbr) {
        String nil = "";
        nbr = removeSpace(nbr);
        if (!nbr.contains("NIL")) {
            int nb = Integer.valueOf(nbr);
            switch (nb) {
                case 0:
                    nil = "CLEAR AND DRY";
                    break;
                case 1:
                    nil = "DAMP";
                    break;
                case 2:
                    nil = "WET or WATER PATCHES";
                    break;
                case 3:
                    nil = "RIME OR FROST COVERED";
                    break;
                case 4:
                    nil = "DRY SNOW";
                    break;
                case 5:
                    nil = "WET SNOW";
                    break;
                case 6:
                    nil = "SLUSH";
                    break;
                case 7:
                    nil = "ICE";
                case 8:
                    nil = "COMPACTED OR ROLLED SNOW";
                    break;
                case 9:
                    nil = "FROZEN RUTS OR RIDGES";
                    break;
            }
        } else {
            nil = nbr;
        }


        return nil;
    }


    private String getCoeff(String nbr) {
        String coef = "";
        nbr = removeSpace(nbr);
        if (!nbr.contains("NIL")) {
            int nb = Integer.valueOf(nbr);
            if (nb > 40 || nb == 5) {
                coef = "GOOD";
            } else if ((nb >= 36 && nb <= 39) || nb == 4) {
                coef = "MEDIUM TO GOOD";
            } else if ((nb >= 30 && nb <= 35) || nb == 3) {
                coef = "MEDIUM";
            } else if ((nb >= 26 && nb <= 29) || nb == 2) {
                coef = "MEDIUM TO POOR";
            } else if (nb <= 25 || nb == 1) {
                coef = "POOR";
            } else {
                coef = nbr;
            }
        } else {
            coef = nbr;
        }


        return coef;
    }


    String removeLines(String string) {
        if (string.contains("\\n")) {
            string = string.replace("\\n", "");
        }
        if (string.contains("\n")) {
            string = string.replace("\n", "");
        }
        return string;
    }

    String removeSpace(String string) {
        if (string.contains(" ")) {
            string = string.replace(" ", "");
        }
        return string;
    }

    String getMonth(int nb) {
        String x = "ND";
        switch (nb) {
            case 1:
                x = "JANUARY";
                break;
            case 2:
                x = "FEBRUARY";
                break;
            case 3:
                x = "MARCH";
                break;
            case 4:
                x = "APRIL";
                break;
            case 5:
                x = "MAY";
                break;
            case 6:
                x = "JUNE";
                break;
            case 7:
                x = "JULY";
                break;
            case 8:
                x = "AUGUST";
                break;
            case 9:
                x = "SEPTEMBER";
                break;
            case 10:
                x = "OCTOBER";
                break;
            case 11:
                x = "NOVEMBER";
                break;
            case 12:
                x = "DECEMBER";
                break;

        }
        return x;
    }
}