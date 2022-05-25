package kots.terminal.homework;

import java.util.List;
import java.util.concurrent.CompletableFuture;

class Application {

    private static final WBCInstitution wbc = new WBCInstitution();
    private static final WBAInstitution wba = new WBAInstitution();

    public static void main(String[] args) {
       wbc.wbcFights().thenCompose(fights -> {
           final List<CompletableFuture<Fight>> completableFutures = combineTwoArrays(fights, wba.wbaFights().join());
       })


    }

    private static List<CompletableFuture<Fight>> combineTwoArrays(List<Fight> fights, List<Fight> join) {
        return
    }
}
