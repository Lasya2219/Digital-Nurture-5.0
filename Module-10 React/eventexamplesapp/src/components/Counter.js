import { Component } from "react";
import "../styles/Counter.css"

class Counter extends Component {
    state = {
        count: 0
    }

    onIncrement = () => {
        this.setState(prevState => ({count: prevState.count+1}));
    }

    onDecrement = () => {
        this.setState(prevState => ({count: prevState.count-1}));
    }

    onWelcome = text => {
        alert(text)
    }

    onPress = () => {
        alert("I was clicked!");
    }

    render() {
        const {count} = this.state;
        return (
            <div>
                <p>{count}</p>
                <div className="buttons">
                    <button onClick={this.onIncrement}>Increment</button> 
                    <button onClick={this.onDecrement}>Decrement</button>
                    <button onClick={() => this.onWelcome("Welcome")}>Say Welcome</button>
                    <button onClick={this.onPress}>Click on me</button>
                </div>
            </div>
        )
    }
}


export default Counter;