package kots.terminal.homework;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

class WBAInstitution {

    CompletableFuture<List<Fight>> wbaFights() {
        return CompletableFuture.supplyAsync(() -> List.of(
                new Fight("Yildirim", "Pudzian", LocalDateTime.now()),
                new Fight("Kliczko", "Włodarczyk", LocalDateTime.now()),
                new Fight("Cieślak", "Pascal", LocalDateTime.now()),
                new Fight("Kliczko", "Masternak", LocalDateTime.now()),
                new Fight("Pascal", "Yildirim", LocalDateTime.now())
        ));
    }
}
