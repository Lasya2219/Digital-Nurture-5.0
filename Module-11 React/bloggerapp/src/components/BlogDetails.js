import { Component } from "react";

class BlogDetails extends Component {
    render() {
        const {blogs} = this.props;
        return (
            <ul>
                {blogs.map(blog => (
                    <div key={blog.id}>
                        <h1>{blog.dname}</h1>
                        <h4>{blog.author}</h4>
                        <p>{blog.description}</p>
                    </div>
                ))}
            </ul>
        )
    }
}

export default BlogDetails;