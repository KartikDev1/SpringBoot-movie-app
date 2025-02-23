package dev.kartik.MovieApp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString  // ✅ Ensures correct printing in logs
public class Movie {
    @Id
    @JsonProperty("id") // ✅ Fix serialization issue
    private ObjectId id;

    @JsonProperty("imdbId")
    private String imdbId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("releaseDate")
    private String releaseDate;

    @JsonProperty("trailerLink")
    private String trailerLink;

    @JsonProperty("poster")
    private String poster;

    @JsonProperty("genres")
    private List<String> genres;

    @JsonProperty("backdrops")
    private List<String> backdrops;

    @DocumentReference
    @JsonProperty("reviewIds")
    @DBRef(lazy = false)
    private List<Review> reviewIds;
}
