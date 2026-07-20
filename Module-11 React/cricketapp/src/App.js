import ListOfPlayers from "./components/ListOfPlayers";
import Scorebelow70 from "./components/Scorebelow70";
import "./App.css";
import players from "./data/PlayerDetails";

import {
    OddPlayers,
    EvenPlayers,
    ListofIndianPlayers,
    IndianPlayers
} from "./components/IndianPlayers";

function App() {

    const IndianTeam = [
        "Sachin1",
        "Dhoni2",
        "Virat3",
        "Rohit4",
        "Yuvraj5",
        "Raina6"
    ];

    var flag = false;

    if (flag === true) {
        return (
            <div className="App">

                <h1>List of Players</h1>
                <ListOfPlayers players={players} />

                <hr />

                <h1>List of Players having Scores Less than 70</h1>
                <Scorebelow70 players={players} />

            </div>
        );
    }

    else {

        return (
            <div>

                <h1>Indian Team</h1>

                <h2>Odd Players</h2>
                {OddPlayers(IndianTeam)}

                <hr />

                <h2>Even Players</h2>
                {EvenPlayers(IndianTeam)}

                <hr />

                <h2>List of Indian Players Merged:</h2>
                <ListofIndianPlayers IndianPlayers={IndianPlayers} />

            </div>
        );
    }
}

export default App;