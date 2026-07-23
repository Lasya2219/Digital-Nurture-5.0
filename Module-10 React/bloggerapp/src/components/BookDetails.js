import { Component } from "react";

class BookDetails extends Component {
    render() {
        const {books} = this.props;
        return (
            <ul>
                {books.map(book => (
                    <div key={book.id}>
                        <h3>{book.bname}</h3>
                        <h4>{book.price}</h4>
                    </div>
                ))}
            </ul>
        )
    }
}

export default BookDetails;