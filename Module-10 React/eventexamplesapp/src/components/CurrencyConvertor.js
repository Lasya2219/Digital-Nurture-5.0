import { Component } from "react";

import '../styles/CurrencyConvertor.css'

class CurrencyConvertor extends Component {
    state = {amount:"", currency:""}

    handleAmount = event => {
        const current = event.target.value;
        this.setState({amount: current})
    }

    handleCurrency = event => {
        const current = event.target.value;
        this.setState({currency: current})
    }

    handleSubmit = () => {
        const {amount, currency} = this.state;
        if(currency.toLowerCase()==="Euro".toLowerCase()) {
            alert("Converting to Euro Amount: "+amount*90)
        } else if(currency.toLowerCase()==="Rupees".toLowerCase()) {
            alert("Converting to Indian Amount: "+amount/90)
        }
    }

    render() {
        return (
            <form>
                <h1 className="heading">Currency Convertor!!!</h1>
                <label>Amount: </label>
                <input type="text" value={this.state.amount}
                onChange={this.handleAmount}/>

                <br /><br />

                <label>Currency:</label>

                <input
                    type="textbox"
                    value={this.state.currency}
                    onChange={this.handleCurrency}
                />
                
                <br/>
                <div>
                    <button onClick={this.handleSubmit}>Submit</button>
                </div>
            </form>
        )
    }
}

export default CurrencyConvertor;