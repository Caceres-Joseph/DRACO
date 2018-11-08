/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Componentes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;

/**
 *
 * @author joseph
 */
public class ideTxtConsolaDasm extends ideTxtConsolaDasmPadre {

    public ideTxtConsolaDasm(TextArea txtDasm, WebView wbSalidaDasm) {
        super(txtDasm, wbSalidaDasm);
    }

    /**
     * Listado de comandos dasm
     */
    private final String tAdd = "ADD";
    private final String tDiff = "DIFF";
    private final String tMult = "MULT";
    private final String tDiv = "DIV";
    private final String tMod = "MOD";
    private final String tPot = "POT";
    private final String tLt = "LT";
    private final String tGt = "GT";
    private final String tLte = "LTE";
    private final String tGte = "GTE";
    private final String tNot = "NOT";
    private final String tAnd = "AND";
    private final String tOr = "OR";
    private final String tBr = "BR";
    private final String tBrIf = "BR_IF";
    private final String tGet_local = "get_local";
    private final String tGet_global = "get_global";
    private final String tSet_local = "set_local";
    private final String tSet_global = "set_global";
    private final String tCall = "Call";
    private final String tEqz = "EQZ";
    private final String tFuncion = "Function";
    private final String tEnd = "END";
    private final String tPrint = "PRINT";
    private final String tTee_local = "TEE_LOCAL";
    private final String tTee_global = "TEE_GLOBAL";

    private final String tCalc = "$calc";
    private final String tRet = "$ret";
    private final String tEtiquetaRetornar="$dasm_retora";

    /*
    +------------------------------------------------+
    |   COMANDOS DASM
    +------------------------------------------------+
     */
    public String getAdd() {
        return tAdd;
    }

    public String getDiff() {
        return tDiff;
    }

    public String getMult() {
        return tMult;
    }

    public String getDiv() {
        return tDiv;
    }

    public String getMod() {
        return tMod;
    }

    public String getPot() {
        return tPot;
    }

    public String getLt() {
        return tLt;
    }

    public String getGt() {
        return tGt;
    }

    public String getLte() {
        return tLte;
    }

    public String getGte() {
        return tGte;
    }

    public String getNot() {
        return tNot;
    }

    public String getAnd() {
        return tAnd;
    }

    public String getOr() {
        return tOr;
    }

    public String getBr(String id) {
        return tBr+ " " + id;
    }

    public String getBrIf(String id) {
        return tBrIf + " " + id;
    }

    public String getGet_local_id(String id) {
        return tGet_local + " " + id;
    }

    public String getGet_local_calc() {
        return tGet_local + " " + tCalc;
    }

    public String getGet_local_ret() {
        return tGet_local + " " + tRet;
    }

    public String getGet_global_id(String id) {
        return tGet_global + " " + id;
    }

    public String getGet_global_calc() {
        return tGet_global + " " + tCalc;
    }

    public String getGet_global_ret() {
        return tGet_global + " " + tRet;
    }

    public String getSet_local_id(String id) {
        return tSet_local + " " + id;
    }

    public String getSet_local_calc() {
        return tSet_local + " " + tCalc;
    }

    public String getSet_local_ret() {
        return tSet_local + " " + tRet;
    }

    public String getSet_global_id(String id) {
        return tSet_global + " " + id;
    }

    public String getSet_global_calc() {
        return tSet_global + " " + tCalc;
    }

    public String getSet_global_ret() {
        return tSet_global + " " + tRet;
    }

    public String getCall(String id) {
        return tCall + " " + id;
    }

    public String getEqz() {
        return tEqz;
    }

    public String getFuncion(String id) {
        return tFuncion + " " + id;
    }

    public String getEnd() {
        return tEnd;
    }

    public String getPrint() {
        return tPrint;
    }

    public String getTee_local(String id) {
        return tTee_local + " " + id;
    }

    public String getTee_global(String id) {
        return tTee_global + " " + id;
    }

    public String gettEtiquetaRetornar() {
        return tEtiquetaRetornar;
    }
    
}
