import { Component } from "react";
import Post from "./Post";

class Posts extends Component {
    constructor(props) {
        super(props);

        this.state = {
            posts: []
        }
    }

    loadPosts() {
        fetch("https://jsonplaceholder.typicode.com/posts")
        .then(response => response.json())
        .then(data => {

            const posts = data.map(
                item => new Post(item.id, item.title, item.body)
            );

            this.setState({
                posts: posts
            });
        })
        .catch(error => {
            throw error;
        })
    }

    componentDidMount() {
        this.loadPosts();
    }

    render() {
        return (
            <>
                {this.state.posts.map(post => (
                    <div key={post.id}>
                        <h2><span style={{ color: "blue" }}>Title:</span> {post.title}</h2>
                        <p>{post.body}</p>
                        <hr/>
                    </div>
                ))}
            </>
        );
    }

    componentDidCatch(error, info) {
        alert("Error: " + error);
        console.log(error);
        console.log(info);
    }
}


export default Posts;