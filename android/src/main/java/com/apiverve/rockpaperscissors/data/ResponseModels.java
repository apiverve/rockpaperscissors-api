// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     RockPaperScissorsData data = Converter.fromJsonString(jsonString);

package com.apiverve.rockpaperscissors.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static RockPaperScissorsData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(RockPaperScissorsData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(RockPaperScissorsData.class);
        writer = mapper.writerFor(RockPaperScissorsData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// RockPaperScissorsData.java

package com.apiverve.rockpaperscissors.data;

import com.fasterxml.jackson.annotation.*;

public class RockPaperScissorsData {
    private long totalRounds;
    private String playerChoiceMode;
    private Game[] games;
    private Results results;
    private String overallWinner;
    private GameRules gameRules;

    @JsonProperty("total_rounds")
    public long getTotalRounds() { return totalRounds; }
    @JsonProperty("total_rounds")
    public void setTotalRounds(long value) { this.totalRounds = value; }

    @JsonProperty("player_choice_mode")
    public String getPlayerChoiceMode() { return playerChoiceMode; }
    @JsonProperty("player_choice_mode")
    public void setPlayerChoiceMode(String value) { this.playerChoiceMode = value; }

    @JsonProperty("games")
    public Game[] getGames() { return games; }
    @JsonProperty("games")
    public void setGames(Game[] value) { this.games = value; }

    @JsonProperty("results")
    public Results getResults() { return results; }
    @JsonProperty("results")
    public void setResults(Results value) { this.results = value; }

    @JsonProperty("overall_winner")
    public String getOverallWinner() { return overallWinner; }
    @JsonProperty("overall_winner")
    public void setOverallWinner(String value) { this.overallWinner = value; }

    @JsonProperty("game_rules")
    public GameRules getGameRules() { return gameRules; }
    @JsonProperty("game_rules")
    public void setGameRules(GameRules value) { this.gameRules = value; }
}

// GameRules.java

package com.apiverve.rockpaperscissors.data;

import com.fasterxml.jackson.annotation.*;

public class GameRules {
    private String rockBeats;
    private String paperBeats;
    private String scissorsBeats;

    @JsonProperty("rock_beats")
    public String getRockBeats() { return rockBeats; }
    @JsonProperty("rock_beats")
    public void setRockBeats(String value) { this.rockBeats = value; }

    @JsonProperty("paper_beats")
    public String getPaperBeats() { return paperBeats; }
    @JsonProperty("paper_beats")
    public void setPaperBeats(String value) { this.paperBeats = value; }

    @JsonProperty("scissors_beats")
    public String getScissorsBeats() { return scissorsBeats; }
    @JsonProperty("scissors_beats")
    public void setScissorsBeats(String value) { this.scissorsBeats = value; }
}

// Game.java

package com.apiverve.rockpaperscissors.data;

import com.fasterxml.jackson.annotation.*;

public class Game {
    private long round;
    private String playerChoice;
    private String playerEmoji;
    private String computerChoice;
    private String computerEmoji;
    private String outcome;
    private String message;

    @JsonProperty("round")
    public long getRound() { return round; }
    @JsonProperty("round")
    public void setRound(long value) { this.round = value; }

    @JsonProperty("player_choice")
    public String getPlayerChoice() { return playerChoice; }
    @JsonProperty("player_choice")
    public void setPlayerChoice(String value) { this.playerChoice = value; }

    @JsonProperty("player_emoji")
    public String getPlayerEmoji() { return playerEmoji; }
    @JsonProperty("player_emoji")
    public void setPlayerEmoji(String value) { this.playerEmoji = value; }

    @JsonProperty("computer_choice")
    public String getComputerChoice() { return computerChoice; }
    @JsonProperty("computer_choice")
    public void setComputerChoice(String value) { this.computerChoice = value; }

    @JsonProperty("computer_emoji")
    public String getComputerEmoji() { return computerEmoji; }
    @JsonProperty("computer_emoji")
    public void setComputerEmoji(String value) { this.computerEmoji = value; }

    @JsonProperty("outcome")
    public String getOutcome() { return outcome; }
    @JsonProperty("outcome")
    public void setOutcome(String value) { this.outcome = value; }

    @JsonProperty("message")
    public String getMessage() { return message; }
    @JsonProperty("message")
    public void setMessage(String value) { this.message = value; }
}

// Results.java

package com.apiverve.rockpaperscissors.data;

import com.fasterxml.jackson.annotation.*;

public class Results {
    private long playerWINS;
    private long computerWINS;
    private long ties;
    private long playerWinPercentage;
    private long computerWinPercentage;
    private long tiePercentage;

    @JsonProperty("player_wins")
    public long getPlayerWINS() { return playerWINS; }
    @JsonProperty("player_wins")
    public void setPlayerWINS(long value) { this.playerWINS = value; }

    @JsonProperty("computer_wins")
    public long getComputerWINS() { return computerWINS; }
    @JsonProperty("computer_wins")
    public void setComputerWINS(long value) { this.computerWINS = value; }

    @JsonProperty("ties")
    public long getTies() { return ties; }
    @JsonProperty("ties")
    public void setTies(long value) { this.ties = value; }

    @JsonProperty("player_win_percentage")
    public long getPlayerWinPercentage() { return playerWinPercentage; }
    @JsonProperty("player_win_percentage")
    public void setPlayerWinPercentage(long value) { this.playerWinPercentage = value; }

    @JsonProperty("computer_win_percentage")
    public long getComputerWinPercentage() { return computerWinPercentage; }
    @JsonProperty("computer_win_percentage")
    public void setComputerWinPercentage(long value) { this.computerWinPercentage = value; }

    @JsonProperty("tie_percentage")
    public long getTiePercentage() { return tiePercentage; }
    @JsonProperty("tie_percentage")
    public void setTiePercentage(long value) { this.tiePercentage = value; }
}