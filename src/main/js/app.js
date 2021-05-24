import React  from 'react';
import ReactDOM from 'react-dom'

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            age: null,
            student: null,
            income: null,
            ageOptions: [],
            studentOptions: [],
            incomeOptions: [],
            products: []
        };

        this.handleChange = this.handleChange.bind(this);
    }

    componentDidMount() {
        fetch('http://localhost:8080/api/questionnaire/options')
            .then(res => res.json())
            .then(data => {
                this.setState({
                    ageOptions: data.ageOptions,
                    studentOptions: data.studentOptions,
                    incomeOptions: data.incomeOptions,
                    age: data.ageOptions[0].name,
                    student: data.studentOptions[0].name,
                    income: data.incomeOptions[0].name
                }, this.getRecommendations);
            })
            .catch(console.log)
    }

    handleChange(event) {
        const {name, value} = event.target
        this.setState({[name]: value}, this.getRecommendations)
    }

    getRecommendations() {
        const {age, student, income} = this.state;
        const query = `?age=${age}&student=${student}&income=${income}`;

        fetch('http://localhost:8080/api/recommendations' + query)
            .then(res => res.json())
            .then(data => {
                this.setState({products: data.products});
            })
            .catch(console.log)
    }

    render() {
        return (
            <div>
                <div>
                    <form>
                        <div>
                            <label htmlFor="age">What's your age?</label>
                            <select name="age" id="age" onChange={this.handleChange}>
                                {this.state.ageOptions.map(age => (
                                    <option key={age.name} value={age.name}>
                                        {age.description}
                                    </option>
                                ))}
                            </select>
                        </div>
                        <div>
                            <label htmlFor="student">Are you a student?</label>
                            <select name="student" id="student" onChange={this.handleChange}>
                                {this.state.studentOptions.map(student => (
                                    <option key={student.name} value={student.name}>
                                        {student.description}
                                    </option>
                                ))}
                            </select>
                        </div>
                        <div>
                            <label htmlFor="income">What's your yearly income?</label>
                            <select name="income" id="income" onChange={this.handleChange}>
                                {this.state.incomeOptions.map(income => (
                                    <option key={income.name} value={income.name}>
                                        {income.description}
                                    </option>
                                ))}
                            </select>
                        </div>
                        <hr/>
                    </form>
                </div>
                <div>
                    {this.state.products.map(product => (
                        <option key={product.name} value={product.name}>
                            {product.name}
                        </option>
                    ))}
                </div>
            </div>
        )
    }
}

ReactDOM.render(
    <App/>,
    document.getElementById('app')
)