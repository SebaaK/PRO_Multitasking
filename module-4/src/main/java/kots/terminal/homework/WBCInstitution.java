package kots.terminal.homework;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

class WBCInstitution {

    CompletableFuture<List<Fight>> wbcFights() {
        return CompletableFuture.supplyAsync(() -> List.of(
                new Fight("Głowacki", "Pudzian", LocalDateTime.now()),
                new Fight("Kliczko", "Włodarczyk", LocalDateTime.now()),
                new Fight("Cieślak", "Pudzian", LocalDateTime.now()),
                new Fight("Kliczko", "Masternak", LocalDateTime.now()),
                new Fight("Pascal", "Yildirim", LocalDateTime.now())
        ));
    }
}
