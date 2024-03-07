import org.example.pojoClasses.BoardResponse;
import org.example.utility.BaseTest;
import org.example.utility.ReadableResponse;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;

public class GetBoardTest extends BaseTest {

    @Test
    public void it_should_get_character_by_id() {

        //Given: prepare requirements
        String id = "";

        //When: send request
        ReadableResponse readableResponse = boardService.getBoard(id);
        BoardResponse boardResponse = readableResponse.getResponse().as(BoardResponse.class);

        //Then: make assertions
        assertThat(boardResponse.getStatusCode()).isEqualTo(200);
//        assertThat(characterResponse.getId()).isEqualTo(2);
//        assertThat(characterResponse.getName()).isEqualTo("Morty Smith");
//        assertThat(characterResponse.getStatus()).isEqualTo(Status.Alive);
//        assertThat(characterResponse.getSpecies()).isEqualTo("Human");
//        assertThat(characterResponse.getGender()).isEqualTo(Gender.Male);
//        assertThat(characterResponse.getOrigin().getName()).isEqualTo("unknown");
//        assertThat(characterResponse.getLocation().getName()).isEqualTo("Citadel of Ricks");
//        assertThat(characterResponse.getLocation().getUrl()).isEqualTo("https://rickandmortyapi.com/api/location/3");
//        assertThat(characterResponse.getImage()).isEqualTo("https://rickandmortyapi.com/api/character/avatar/2.jpeg");
//        assertThat(characterResponse.getUrl()).isEqualTo("https://rickandmortyapi.com/api/character/2");
//        assertThat(characterResponse.getCreated()).isEqualTo("2017-11-04T18:50:21.651Z");

    }
}
