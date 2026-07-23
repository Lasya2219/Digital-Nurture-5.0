import { Component } from "react";

class CourseDetails extends Component {
    render() {
        const {courses} = this.props;
        return (
            <ul>
                {courses.map(course => (
                    <div key={course.id}>
                        <h1>{course.cname}</h1>
                        <h4>{course.date}</h4>
                    </div>
                ))}
            </ul>
        )
    }
}

export default CourseDetails;