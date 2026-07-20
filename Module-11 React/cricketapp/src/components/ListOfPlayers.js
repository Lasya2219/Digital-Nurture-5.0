import players from "../data/PlayerDetails";
import { Component } from "react";

class ListOfPlayers extends Component {



    
    render() {
        return (
            <div>
                <ul>
                    {
                        players.map((item) => {
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


export default ListOfPlayers;