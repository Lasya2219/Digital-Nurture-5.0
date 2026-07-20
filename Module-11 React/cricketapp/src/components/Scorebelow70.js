import players from "../data/PlayerDetails";
import { Component } from "react";

class Scorebelow70 extends Component {    
    render() {
        const lowScorePlayers = players.filter(player => player.score<70)
        return (
            <div>
                <ul>
                    {
                        lowScorePlayers.map((item) => {
                            return (
                                <div>
                                    <li>Mr. {item.name} <span>{item.score}</span></li>
                                </div>
                            )
                        })
                    }
                </ul>
            </div>
        )
    }
}


export default Scorebelow70;